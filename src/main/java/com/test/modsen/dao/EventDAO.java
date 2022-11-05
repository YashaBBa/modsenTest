package com.test.modsen.dao;

import com.test.modsen.model.Event;

import java.util.List;

public interface EventDAO {
    List<Event> getEvents();

    void deleteEvent(int id);

    void addEvent(Event event);

    void updateEvent(Event event);

    Event getEventById(int id);
}
