package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("Sasha", "Ivanov", (byte) 25);
        userDaoHibernate.saveUser("Ivan", "Bogomolov", (byte) 51);
        userDaoHibernate.saveUser("Zheka", "Kruchinin", (byte) 23);
        userDaoHibernate.saveUser("Gosha", "Klatov", (byte) 19);
        //userDaoHibernate.removeUserById(1);
        //userDaoHibernate.cleanUsersTable();
        //userDaoHibernate.dropUsersTable();

        //System.out.println(userDaoHibernate.getAllUsers());
       /* UserServiceImpl userDaoJDBC = new UserServiceImpl();
        userDaoJDBC.dropUsersTable();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Sasha", "Ivanov", (byte) 25);
        userDaoJDBC.saveUser("Ivan", "Bogomolov", (byte) 51);
        userDaoJDBC.saveUser("Zheka", "Kruchinin", (byte) 23);
        userDaoJDBC.saveUser("Gosha", "Klatov", (byte) 19);
        System.out.println(userDaoJDBC.getAllUsers());*/

    }
}
