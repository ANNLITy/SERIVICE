package Application;
import DAO.RoleDAO;
import DAO.RoleDAOImpl;
import DAO.UserDAO;
import DAO.UserDAOImpl;
import model.Role;
import model.User;

public class Application {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();
        RoleDAO roleDAO = new RoleDAOImpl();

        Role role = new Role(3, "Third_plan");
        User user = new User(3,"Andrey", "T", "CCC", role);

        roleDAO.getAll().forEach(System.out::println);
        userDAO.getUsers().forEach(System.out::println);
        userDAO.getByRole(role).forEach(System.out::println);
    }
}
