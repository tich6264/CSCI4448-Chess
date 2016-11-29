package com.closetbot.controller;

import com.closetbot.model.Closet;
import com.closetbot.model.Gender;
import com.closetbot.model.OutfitCloset;
import com.closetbot.model.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by Owner on 11/2/2016.
 */
public class DatabaseProxy {

    private static SessionFactory factory;
    private static Configuration  cfg = new Configuration();

    {
        cfg.configure("hibernate.cfg.xml"); //load in our hibernate cfg
        factory = cfg.buildSessionFactory(); //make  a factory based on the configuration
    }
    public User createUser(String firstName, String lastName, Gender g, String username, String password)
    {
        Session session = factory.openSession();

        User newUser = new User();
        newUser.setCloset(new Closet(newUser));
        newUser.setOutfits(new OutfitCloset());
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setGender(g);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);

        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            session.save(newUser);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
        }

        return newUser;
    }
    public boolean saveUser(User u){

        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(u);
            tx.commit();
        }catch (HibernateException e){
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public User getUser(String username, String password){
       Session session = factory.openSession();

            CriteriaBuilder     builder  = session.getCriteriaBuilder();
            CriteriaQuery<User> criteria = builder.createQuery(User.class);
            Root<User>          from     = criteria.from(User.class);
            criteria.select(from);
            criteria.where(builder.equal(from.get("username"),username));
            criteria.where(builder.equal(from.get("password"),password));
            TypedQuery<User> typed = session.createQuery(criteria);
            try {
                return typed.getSingleResult();
            } catch (final NoResultException nre) {
                return null;
            }
        }
    }
}
