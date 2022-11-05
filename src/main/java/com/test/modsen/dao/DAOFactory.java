package com.test.modsen.dao;

import com.test.modsen.dao.impl.EventDAOImpl;
import com.test.modsen.dao.impl.SortDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final EventDAO eventDAO = new EventDAOImpl();

    private final SortDAO sortDAO = new SortDAOImpl();

    public static DAOFactory getInstance() {
        return instance;
    }

    public DAOFactory() {
    }

    public EventDAO getEventDAO() {
        return eventDAO;
    }

    public SortDAO getSortDAO() {
        return sortDAO;
    }
}
