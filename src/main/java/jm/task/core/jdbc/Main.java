package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userServiceImpl = new UserServiceImpl();
        userServiceImpl.createUsersTable();
        userServiceImpl.saveUser("Sasha", "Ivanov", (byte) 25);
        userServiceImpl.saveUser("Ivan", "Bogomolov", (byte) 51);
        userServiceImpl.saveUser("Zheka", "Kruchinin", (byte) 23);
        userServiceImpl.saveUser("Gosha", "Klatov", (byte) 19);
        System.out.println(userServiceImpl.getAllUsers());
        userServiceImpl.cleanUsersTable();
        userServiceImpl.dropUsersTable();
    }
}
