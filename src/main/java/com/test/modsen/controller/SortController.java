package com.test.modsen.controller;


import com.test.modsen.dao.DAOFactory;
import com.test.modsen.dao.EventDAO;
import com.test.modsen.dao.SortDAO;
import com.test.modsen.dao.impl.EventDAOImpl;
import com.test.modsen.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/auth")
public class SortController {

    @GetMapping("/sort")
    public String sortByKeyWord(@RequestParam String keyWord, Model model) {
        if (keyWord.equals("All")) {
            return "redirect:localhost:8080/getData";
        }

        DAOFactory daoFactory = DAOFactory.getInstance();

        EventDAO eventDAO = daoFactory.getEventDAO();
        List<Event> eventList = eventDAO.getEvents();
        SortDAO sortDAO = daoFactory.getSortDAO();


        List<Event> list = sortDAO.sortList(eventList, keyWord);
        model.addAttribute("eventList", list);
        return "mainPage";
    }

    @GetMapping("/filter")
    public String filterByKeyWord(@RequestParam String keyWord, Model model,@RequestParam String placeholder) {
        if (keyWord.equals("All")) {
            return "redirect:getData";
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        EventDAO eventDAO = daoFactory.getEventDAO();
        List<Event> eventList = eventDAO.getEvents();
        SortDAO sortDAO = daoFactory.getSortDAO();
        eventList = sortDAO.filtrList(eventList, keyWord, placeholder);
        model.addAttribute("eventList", eventList);
        return "mainPage";
    }
}
