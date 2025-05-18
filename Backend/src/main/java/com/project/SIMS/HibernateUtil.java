package com.project.SIMS;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    // static call runs once when class is loaded
    static {
        try {
            //Creating factory for opening connections/sessions to DB
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml") //loading config
                    .buildSessionFactory(); //building singleton of SessionFactory
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    //Providing global access to singleton of SessionFactory to get connection/session
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }
}

