package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userDaoJDBC = new UserServiceImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Sasha", "Ivanov", (byte) 25);
        userDaoJDBC.saveUser("Ivan", "Bogomolov", (byte) 51);
        userDaoJDBC.saveUser("Zheka", "Kruchinin", (byte) 23);
        userDaoJDBC.saveUser("Gosha", "Klatov", (byte) 19);
        System.out.println(userDaoJDBC.getAllUsers());
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();
        System.out.println("Finish");

    }
}
