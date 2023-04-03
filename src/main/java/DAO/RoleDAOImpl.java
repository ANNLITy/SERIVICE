package DAO;

import config.HibernateSessionFactoryUtil;
import model.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoleDAOImpl implements RoleDAO {
    @Override
    public void create(Role role) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
        }
    }

    @Override
    public Role getRoleById(int id) {
        Role role;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            role = session.get(Role.class, id);
            transaction.commit();
        }
        return role;
    }

    @Override
    public void update(Role role) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(role);
            transaction.commit();
        }
    }

    @Override
    public void update(List<Role> roleList) {
        roleList.forEach(this::update);
    }

    @Override
    public void delete(Role role) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(role);
            transaction.commit();
        }
    }

    @Override
    public List<Role> getAll() {
        List<Role> roleList;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            roleList = session.createQuery("FROM Role", Role.class).list();
            transaction.commit();
        }
        return roleList;
    }
}