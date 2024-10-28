package ticketservice.dao;

import org.springframework.stereotype.Component;
import ticketservice.ticket.Ticket;
import ticketservice.ticket.TicketType;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class TicketDao {
    private DataSource dataSource;
    private PreparedStatement preparedStatement = null;

    public TicketDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private static final String SAVE_TICKET = "INSERT INTO tickets (ticket_id, user_id, ticket_type, creation_date) VALUES (?, ?, ?::ticket_type, ?)";
    private static final String FETCH_TICKET_BY_ID = "SELECT ticket_id, user_id, ticket_type, creation_date FROM tickets WHERE ticket_id = ?";
    private static final String FETCH_TICKET_BY_USER_ID = "SELECT ticket_id, user_id, ticket_type, creation_date FROM tickets WHERE user_id = ?";
    private static final String UPDATE_TICKET_TYPE = "UPDATE tickets SET ticket_type = ?::ticket_type WHERE ticket_id = ?";

    public void saveTicket(Ticket ticket, int userId) {
        try (Connection connection = dataSource.getConnection()) {
            preparedStatement = connection.prepareStatement(SAVE_TICKET);
            preparedStatement.setInt(1, ticket.getId());
            preparedStatement.setInt(2, userId);
            preparedStatement.setString(3, ticket.getTicketType().name());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(ticket.getTicketCreationTime()));
            System.out.println(preparedStatement.executeUpdate());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Ticket fetchTicketById(int ticketId) {
        try (Connection connection = dataSource.getConnection()) {
            preparedStatement = connection.prepareStatement(FETCH_TICKET_BY_ID);
            preparedStatement.setInt(1, ticketId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(resultSet.getInt(1));
                ticket.setTicketType(TicketType.valueOf(resultSet.getString(3)));
                ticket.setTime(resultSet.getTimestamp(4).toLocalDateTime());
                resultSet.close();
                return ticket;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Ticket> fetchTicketByUserId(int userId) {
        try (Connection connection = dataSource.getConnection()) {
            preparedStatement = connection.prepareStatement(FETCH_TICKET_BY_USER_ID);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Ticket> tickets = new ArrayList<>();
            while (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(resultSet.getInt(1));
                ticket.setTicketType(TicketType.valueOf(resultSet.getString(3)));
                ticket.setTime(resultSet.getTimestamp(4).toLocalDateTime());
                tickets.add(ticket);
            }
            resultSet.close();
            return tickets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTicketType(int ticketId, TicketType ticketType) {
        try (Connection connection = dataSource.getConnection()) {
            preparedStatement = connection.prepareStatement(UPDATE_TICKET_TYPE);
            preparedStatement.setString(1, ticketType.name());
            preparedStatement.setInt(2, ticketId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
