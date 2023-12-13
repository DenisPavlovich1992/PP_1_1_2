package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    Connection connection = Util.getConnection();
    public void createUsersTable() {
        String createTableSQL = "CREATE TABLE USER " + "(id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255), " + "lastName VARCHAR(255), " + "age TINYINT)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) {
            preparedStatement.executeUpdate();
            System.out.println("Таблица USER создана успешно!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        String dropTableSQL = "DROP TABLE USER";

        try (PreparedStatement preparedStatement = connection.prepareStatement(dropTableSQL)) {
            preparedStatement.executeUpdate();
            System.out.println("Таблица USER удалена успешно!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String insertUserSQL = "INSERT INTO USER (name, lastName, age) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                long userId = generatedKeys.getLong(1);
                System.out.println("User с именем – " + name + " добавлен в базу данных");
            } else {
                System.out.println("Ошибка при получении сгенерированного ID пользователя.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String removeUserSQL = "DELETE FROM USER WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(removeUserSQL)) {
            preparedStatement.setLong(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Пользователь с ID " + id + " удален успешно!");
            } else {
                System.out.println("Пользователь с ID " + id + " не найден.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String getAllUsersSQL = "SELECT * FROM USER";

        try (PreparedStatement preparedStatement = connection.prepareStatement(getAllUsersSQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                byte age = resultSet.getByte("age");

                User user = new User(name, lastName, age);
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }

    public void cleanUsersTable() {
        String cleanTableSQL = "DELETE FROM USER";

        try (PreparedStatement preparedStatement = connection.prepareStatement(cleanTableSQL)) {
            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Таблица USER очищена. Удалено записей: " + rowsAffected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

