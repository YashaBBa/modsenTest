package com.test.modsen.dao.impl;

import com.test.modsen.config.HibernateConfig;
import com.test.modsen.dao.EventDAO;
import com.test.modsen.model.Event;
import org.hibernate.ObjectDeletedException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.EntityTransaction;

public class EventDAOImpl implements EventDAO {

    @Override
    public List<Event> getEvents() {
        Session session = HibernateConfig.getSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Event ");
        List<Event> list = (List<Event>) query.list();
        session.getTransaction().commit();

        return list;
    }

    @Override
    public void deleteEvent(int id) {
        Session session = HibernateConfig.getSession();
        session.beginTransaction();
        Event event = session.load(Event.class, id);
        session.delete(event);
        session.getTransaction().commit();
    }

    @Override
    public void addEvent(Event event) {
        Session session = HibernateConfig.getSession();
        session.beginTransaction();
        session.save(event);
        session.getTransaction().commit();
    }

    @Override
    public void updateEvent(Event event) {
        Session session = HibernateConfig.getSession();
        session.beginTransaction();
        session.update(event);
        session.getTransaction().commit();
    }

    @Override
    public Event getEventById(int id) {


            Session session = HibernateConfig.getSession();
            session.beginTransaction();
          Event event = session.load(Event.class, id);
            session.getTransaction().commit();



        return event;
    }
}
