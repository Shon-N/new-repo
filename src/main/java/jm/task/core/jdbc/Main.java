package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("John", "Doe", (byte) 21);
        userService.saveUser("Steve", "Jobs", (byte) 32);
        userService.saveUser("Jack", "Nelson", (byte) 43);
        userService.saveUser("Robert", "Oppenhaimer", (byte) 54);

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
