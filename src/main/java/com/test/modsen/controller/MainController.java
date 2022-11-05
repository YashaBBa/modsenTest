package com.test.modsen.controller;

import com.test.modsen.config.HibernateConfig;
import com.test.modsen.dao.DAOFactory;
import com.test.modsen.dao.EventDAO;
import com.test.modsen.model.Event;
import com.test.modsen.service.EventService;
import com.test.modsen.service.ServiceFactory;
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

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        List<Event> list = eventService.getEvents();
        model.addAttribute("eventList", list);
        return "mainPage";
    }

    @PostMapping("/deleteEvent/{event}")
    public String deleteEvent(@PathVariable("event") int id) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        eventService.deleteEvent(id);
        return "redirect:/getData";
    }

    @PostMapping("/updateEvent")
    public String updateEvent(Event event) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        eventService.updateEvent(event);
        return "redirect:/getData";
    }

    @GetMapping("/getEvent/byId")
    public String getEventById(@RequestParam int id, Model model) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        return "forOneEvent";
    }

    @PostMapping("/addNewEvent")
    public String createNewEvent(Event event) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        eventService.addEvent(event);
        return "redirect:getData";
    }


}
