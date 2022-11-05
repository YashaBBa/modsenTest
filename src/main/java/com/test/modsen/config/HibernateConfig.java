package com.test.modsen.config;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;


public class HibernateConfig {

    private static SessionFactory sessionFactory;


    static {
        try {
            org.hibernate.cfg.Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }

}
