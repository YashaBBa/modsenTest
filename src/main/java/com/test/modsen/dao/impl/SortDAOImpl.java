package com.test.modsen.dao.impl;

import com.test.modsen.dao.SortDAO;
import com.test.modsen.model.Event;

import java.util.List;
import java.util.stream.Collectors;

public class SortDAOImpl implements SortDAO {
    @Override
    public List<Event> sortList(List<Event> eventList, String keyWord) {

        switch (keyWord) {
            case "subject":
                eventList = eventList.stream().sorted((x, y) -> x.getSubject().compareTo(y.getSubject())).collect(Collectors.toList());
                break;
            case "organizer":
                eventList = eventList.stream().sorted((x, y) -> x.getOrganizer().compareTo(y.getOrganizer())).collect(Collectors.toList());
                break;
            case "time":
                eventList = eventList.stream().sorted((x, y) -> x.getTime().compareTo(y.getTime())).collect(Collectors.toList());
                break;

            default:
                System.err.println("Unknown Key Word");
                break;

        }
        return eventList;
    }

    @Override
    public List<Event> filtrList(List<Event> eventList, String keyWord, String placeHolder) {
        switch (placeHolder) {
            case "subject":
                eventList = eventList.stream().filter(x -> x.getSubject().equals(keyWord)).collect(Collectors.toList());
                break;
            case "organizer":
                eventList = eventList.stream().filter(x -> x.getOrganizer().equals(keyWord)).collect(Collectors.toList());
                break;
            case "time":
                eventList = eventList.stream().filter(x -> x.getTime().equals(keyWord)).collect(Collectors.toList());
                break;
            default:
                System.err.println("WRONG");


        }
        return eventList;
    }
}
