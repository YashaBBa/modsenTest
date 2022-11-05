package com.test.modsen.controller;


import com.test.modsen.dao.DAOFactory;
import com.test.modsen.dao.EventDAO;
import com.test.modsen.model.Event;

import org.springframework.web.bind.annotation.*;




import java.util.List;

@RestController
@RequestMapping("/rest")
public class RController {

    @GetMapping("/getData")
    public String getAllData() {

        DAOFactory daoFactory = DAOFactory.getInstance();
        EventDAO eventDAO = daoFactory.getEventDAO();
        List<Event> list = eventDAO.getEvents();
        String result = "";
        for (Event student : list) {
            result += student.toString() + "\n";
        }
        return result;
    }

    @GetMapping("/getEvent/byId")
    public String getEventById(@RequestParam Integer id) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        EventDAO eventDAO = daoFactory.getEventDAO();
        Event event = eventDAO.getEventById(id);

        return event.toString();
    }

    @PostMapping("/addNewUser")
    public String addEvent(Event event) {

        DAOFactory daoFactory = DAOFactory.getInstance();
        EventDAO eventDAO = daoFactory.getEventDAO();
        eventDAO.addEvent(event);
        return event.toString();
    }

    @PostMapping("/deleteEvent/{event}")
    public String deleteEvent(@PathVariable("event") int id) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        EventDAO eventDAO = daoFactory.getEventDAO();
        eventDAO.deleteEvent(id);
        return "deleted";
    }

    @PostMapping("/updateEvent")
    public String updateUser(Event event) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        EventDAO eventDAO = daoFactory.getEventDAO();
        eventDAO.updateEvent(event);
        return "updated";
    }
}
