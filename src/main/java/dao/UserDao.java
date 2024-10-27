package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import user.User;

public class UserDao {
    public void saveUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
    }

    public User getUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public void deleteUser(int userId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE FROM User WHERE id = :user_id")
                .setParameter("user_id", userId)
                .executeUpdate();
        transaction.commit();
        session.close();
    }
}