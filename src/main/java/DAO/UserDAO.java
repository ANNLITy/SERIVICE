package DAO;
import model.Role;
import model.User;
import java.util.List;

public interface UserDAO {
    List<User> getUsers();
    User readById(int id);
    List<User> getByRole(Role role);
    void deleteUser(User user);
    void create(User user);
    void update(User user);

}