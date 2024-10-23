package dao;

import jdbc.CustomDataSource;
import ticket.Ticket;
import ticket.TicketType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDao {
    private final CustomDataSource dataSource = CustomDataSource.getInstance();
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    private static final String SAVE_TICKET = "INSERT INTO tickets (ticket_id, user_id, ticket_type, creation_date) VALUES (?, ?, ?::ticket_type, ?)";
    private static final String FETCH_TICKET_BY_ID = "SELECT ticket_id, user_id, ticket_type, creation_date FROM tickets WHERE ticket_id = ?";
    private static final String FETCH_TICKET_BY_USER_ID = "SELECT ticket_id, user_id, ticket_type, creation_date FROM tickets WHERE user_id = ?";
    private static final String UPDATE_TICKET_TYPE = "UPDATE tickets SET ticket_type = ?::ticket_type WHERE id = ?";

    public void saveTicket(Ticket ticket, int userId) {
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(SAVE_TICKET);
            preparedStatement.setInt(1, ticket.getId());
            preparedStatement.setInt(2, userId);
            preparedStatement.setString(3, ticket.getTicketType().name());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(ticket.getTicketCreationTime()));
            System.out.println(preparedStatement.executeUpdate());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeResources();
        }
    }

    public Ticket fetchTicketById(int ticketId) {
        try {
            connection = dataSource.getConnection();
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
        } finally {
            closeResources();
        }
        return null;
    }

    public List<Ticket> fetchTicketByUserId(int userId) {
        try {
            connection = dataSource.getConnection();
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
        } finally {
            closeResources();
        }
    }

    public void updateTicketType(int ticketId, TicketType ticketType) {
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_TICKET_TYPE);
            preparedStatement.setString(1, ticketType.name());
            preparedStatement.setInt(2, ticketId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources();
        }
    }

    private void closeResources() {
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
