package ticketservice.dao;

import org.springframework.stereotype.Repository;
import ticketservice.user.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Timestamp;


@Repository
public class UserDao {
    private DataSource dataSource;
    private PreparedStatement preparedStatement = null;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private static final String SAVE_USER = "INSERT INTO users (user_id, name, creation_date) VALUES (?, ?, ?)";
    private static final String FETCH_USER_BY_ID = "SELECT user_id, name, creation_date FROM users WHERE user_id = ?";
    private static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE user_id = ?";

    public void saveUser(User user) {
        try (Connection connection = dataSource.getConnection()) {
            preparedStatement = connection.prepareStatement(SAVE_USER);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(user.getCreationDate()));
            System.out.println(preparedStatement.executeUpdate());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User fetchUser(int id) {
        try (Connection connection = dataSource.getConnection()) {
            preparedStatement = connection.prepareStatement(FETCH_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setCreationDate(resultSet.getTimestamp(3).toLocalDateTime());
                resultSet.close();
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void deleteUser(int id) {
        try (Connection connection = dataSource.getConnection()) {
            preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}