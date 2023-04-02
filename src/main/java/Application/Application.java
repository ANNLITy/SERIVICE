package Application;
import DAO.RoleDAO;
import DAO.RoleDAOImpl;
import DAO.UserDAO;
import DAO.UserDAOImpl;
import model.Role;
import model.User;

import java.util.Set;

public class Application {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();
        RoleDAO roleDAO = new RoleDAOImpl();

        Role role = new Role(3, "Third_plan");
        User user = new User(3,"Andrey", "T", "CCC", Set.of(role));
        roleDAO.create(role);
        userDAO.create(user);
        userDAO.getUsers().forEach(System.out::println);
        for (User userDAOUser : userDAO.getUsers()) {
            System.out.println(userDAOUser);
        }
            System.out.println(userDAO.readById(1));
        userDAO.create(user);
        roleDAO.create(role);
        userDAO.update(user);
        userDAO.deleteUser(user);
        userDAO.getByRole(role);
        roleDAO.getAll().forEach(System.out::println);
        userDAO.getUsers().forEach(System.out::println);
        userDAO.getByRole(role).forEach(System.out::println);
    }
}
