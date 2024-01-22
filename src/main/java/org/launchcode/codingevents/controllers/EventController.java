package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("/events")
public class EventController {

    private final List<Event> events = new ArrayList<>();
    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", events);
        return "events/index";
    }

    @GetMapping("/create")
    public String create() {
        return "events/create";
    }
    @PostMapping("/create")
    public String create(@RequestParam String eventName) {
       events.add(new Event(eventName));
    return "redirect:/";
    }
}
