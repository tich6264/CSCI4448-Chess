package com.closetbot.controller;

import com.closetbot.model.Closet;
import com.closetbot.model.Gender;
import com.closetbot.model.OutfitCloset;
import com.closetbot.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 11/2/2016.
 */

public class DatabaseProxy {

    private static SessionFactory factory;
    private static Configuration cfg = new Configuration();

    {
        cfg.configure("hibernate.cfg.xml"); //load in our hibernate cfg
        factory = cfg.buildSessionFactory(); //make  a factory based on the configuration
    }

    public User createUser(String username, String password) {
        return createUser("Bob", "Smith", Gender.MALE, username, password);
    }

    public User createUser(String firstName, String lastName, Gender g, String username, String password) {
        Session session = factory.openSession();

        User newUser = new User();
        newUser.setCloset(new Closet());
        newUser.setOutfits(new OutfitCloset());
        newUser.setUsername(username.trim());
        newUser.setPassword(password.trim());
        newUser.setGender(g);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);

        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(newUser);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }

        return newUser;
    }

    public boolean saveUser(User u) {

        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            System.out.println("Saving user");
            session.saveOrUpdate(u);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public User getUser(String username, String password) {
        Session session = factory.openSession();

        org.hibernate.query.Query query = session.createQuery("SELECT U FROM User U WHERE username = :username AND password = :password");
        query.setParameter("password", password);
        query.setParameter("username", username);
        ArrayList<User> results = (ArrayList<User>) query.list();
        try {
            return (User) results.get(0);
        } catch (Exception e) {
            return null;
        }
        //CriteriaBuilder     builder  = session.getCriteriaBuilder();
        //CriteriaQuery<User> criteria = builder.createQuery(User.class);
        //Root<User>          from     = criteria.from(User.class);
        //criteria.select(from);
        //criteria.where(builder.equal(from.get("username"), username.trim()));
        //criteria.where(builder.equal(from.get("password"), password.trim()));
        //TypedQuery<User> typed = session.createQuery(criteria);
        //try {
        //    return typed.getSingleResult();
        //} catch (final NoResultException nre) {
        //    session.close();
        //    return null;
        //}
    }
    public boolean userExists(String username){
        Session session = factory.openSession();
        org.hibernate.query.Query query = session.createQuery("SELECT U FROM User U WHERE username = :username");
        query.setParameter("username", username);
        List results = query.list();
        return results.size() > 0;

    }
}
