package DAO;
import model.Role;
import java.util.List;

public interface RoleDAO {
    void create(Role role);
    Role getRoleById(int id);
    void update(Role role);
    void update(List<Role> roleList);
    void delete(Role role);
    List<Role> getAll();
}