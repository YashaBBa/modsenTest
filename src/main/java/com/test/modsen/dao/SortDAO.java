package com.test.modsen.dao;

import com.test.modsen.model.Event;

import java.util.List;

public interface SortDAO {
    List<Event> sortList(List<Event> litEvent,String keyWord);

    List<Event> filtrList(List<Event> eventList, String keyWord, String placeHolder);
}
