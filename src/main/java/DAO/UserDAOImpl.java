package DAO;

import config.HibernateSessionFactoryUtil;
import model.Role;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getUsers() {
        List<User> users;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            users = session.createQuery("FROM User", User.class).list();
            transaction.commit();
        }
        return users;
    }

    @Override
    public User readById(int id) {
        User user;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<User> query = session.createQuery("FROM User u JOIN FETCH u.roleSet WHERE u.id = :id");
            query.setParameter("id", id);
            user = query.getSingleResult();
            transaction.commit();
        }
        return user;
    }

    @Override
    public List<User> getByRole(Role role) {
        List<User> users;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<User> query = session.createQuery("FROM User u JOIN FETCH u.roleSet r WHERE r = :role", User.class);
            query.setParameter("role", role);
            users = query.getResultList();
            transaction.commit();
        }
        return users;
    }

    @Override
    public void deleteUser(User user) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        }
    }

    @Override
    public void create(User user) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
    }

    @Override
    public void update(User user) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
    }
}
