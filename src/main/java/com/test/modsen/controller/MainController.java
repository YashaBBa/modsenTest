package com.test.modsen.controller;

import com.test.modsen.config.HibernateConfig;
import com.test.modsen.dao.DAOFactory;
import com.test.modsen.dao.EventDAO;
import com.test.modsen.model.Event;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class MainController {
    @GetMapping("/getData")
    public String getAllData(Model model) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        EventDAO eventDAO = daoFactory.getEventDAO();
        List<Event> list = eventDAO.getEvents();
        model.addAttribute("eventList", list);
        return "mainPage";
    }

    @PostMapping("/deleteEvent/{event}")
    public String deleteEvent(@PathVariable("event") int id) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        EventDAO eventDAO = daoFactory.getEventDAO();
        eventDAO.deleteEvent(id);
        return "redirect:/getData";
    }

    @PostMapping("/updateEvent")
    public String updateUser(Event event) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        EventDAO eventDAO = daoFactory.getEventDAO();
        eventDAO.updateEvent(event);
        return "redirect:/getData";
    }

    @GetMapping("/getEvent/byId")
    public String getEventById(@RequestParam int id, Model model) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        EventDAO eventDAO = daoFactory.getEventDAO();
        Event event = eventDAO.getEventById(id);
        model.addAttribute("event", event);
        return "forOneEvent";
    }

    @PostMapping("/addNewEvent")
    public String createNewEvent(Event event) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        EventDAO eventDAO = daoFactory.getEventDAO();
        eventDAO.addEvent(event);
        return "redirect:getData";
    }


}
