package com.test.modsen.controller;


import com.test.modsen.dao.DAOFactory;
import com.test.modsen.dao.EventDAO;
import com.test.modsen.model.Event;

import com.test.modsen.service.EventService;
import com.test.modsen.service.ServiceFactory;
import com.test.modsen.service.SortService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/rest")
public class RController {

    @GetMapping("/getData")
    public String getAllData() {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        List<Event> list = eventService.getEvents();
        String result = "";
        for (Event student : list) {
            result += student.toString() + "\n";
        }
        return result;
    }

    @GetMapping("/getEvent/byId")
    public String getEventById(@RequestParam Integer id) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        Event event = eventService.getEventById(id);
        return event.toString();
    }

    @PostMapping("/addNewEvent")
    public String addEvent(Event event) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        eventService.addEvent(event);
        return event.toString();
    }

    @PostMapping("/deleteEvent/{event}")
    public String deleteEvent(@PathVariable("event") int id) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        eventService.deleteEvent(id);
        return "deleted";
    }

    @PostMapping("/updateEvent")
    public String updateEvent(Event event) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        eventService.updateEvent(event);
        return "updated";
    }

    @GetMapping("/sort")
    public String sortByKeyWord(@RequestParam String keyWord) {
        if (keyWord.equals("All")) {
            return "redirect:localhost:8080/getData";
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        List<Event> eventList = eventService.getEvents();
        SortService sortService = serviceFactory.getSortService();
        List<Event> list = sortService.sortList(eventList, keyWord);

        return list.toString();
    }

    @GetMapping("/filter")
    public String filterByKeyWord(@RequestParam String keyWord, @RequestParam String placeholder) {
        if (keyWord.equals("All")) {
            return "redirect:getData";
        }
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EventService eventService = serviceFactory.getEventService();
        List<Event> eventList = eventService.getEvents();
        SortService sortService = serviceFactory.getSortService();
        eventList = sortService.filtrList(eventList, keyWord, placeholder);

        return eventList.toString();
    }
}
