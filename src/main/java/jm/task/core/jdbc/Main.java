package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

public class Main {
    public static void main(String[] args) {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("Sasha", "Ivanov", (byte) 25);
        userDaoHibernate.saveUser("Ivan", "Bogomolov", (byte) 51);
        userDaoHibernate.saveUser("Zheka", "Kruchinin", (byte) 23);
        userDaoHibernate.saveUser("Gosha", "Klatov", (byte) 19);
        System.out.println(userDaoHibernate.getAllUsers());
        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.dropUsersTable();
    }
}
