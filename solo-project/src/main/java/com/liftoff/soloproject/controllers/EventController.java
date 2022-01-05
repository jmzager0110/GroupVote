package com.liftoff.soloproject.controllers;

import com.liftoff.soloproject.data.EventRepository;
import com.liftoff.soloproject.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class EventController  extends AbstractBaseController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping
    public String listEvents(Model model) {
        Iterable<Event> allEvents = eventRepository.findAll();
        model.addAttribute("events", allEvents);
        return "events/list";
    }

    @GetMapping(value = "create")
    public String displayCreateEventForm(Model model, HttpServletRequest request) {
        model.addAttribute(new Event());
        model.addAttribute("actionUrl", request.getRequestURI());
        model.addAttribute("title", "Create Event");

        return "events/create-or-update";
    }

    @PostMapping(value = "create")
    public String processCreateEventForm(@Valid @ModelAttribute Event event,
                                         Errors errors) {

        if (errors.hasErrors())
            return "events/create-or-update";
        eventRepository.save(event);

        return "redirect:/events/detail/" + event.getId();
    }

    @GetMapping(value = "detail/{uid}")
    public String displayEventDetails(@PathVariable int id, Model model) {

        model.addAttribute("title", "Event Details");

        Optional<Event> result = eventRepository.findById(id);
        if (result.isPresent()) {
            Event event = result.get();
            model.addAttribute(event);

        } else {
            model.addAttribute(MESSAGE_KEY, "warning|No event found with id: " + Integer.toString(id));
        }

        return "events/details";
    }

    @GetMapping(value = "update/{uid}")
    public String displayUpdateEventForm(@PathVariable int id, Model model, HttpServletRequest request) {

        model.addAttribute("title", "Update Event");
        model.addAttribute("actionUrl", request.getRequestURI());

        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            model.addAttribute(event.get());

        } else {
            model.addAttribute(MESSAGE_KEY, "warning|No event found with id: " + Integer.toString(id));
        }

        return "events/create-or-update";
    }

    @PostMapping(value = "update/{uid}")
    public String processUpdateEventForm(@Valid @ModelAttribute Event event,
                                         RedirectAttributes model,
                                         Errors errors,
                                         @RequestParam(name = "volunteers", required = false) List<Integer> volunteerUids) {

        if (errors.hasErrors())
            return "events/create-or-update";


        eventRepository.save(event);
        //model.addFlashAttribute(MESSAGE_KEY, "success|Updated event: " + event.getEventName());
        //TODO:Uncomment after add g&s to Event
        return "redirect:/events/detail/" + event.getId();
    }

    @PostMapping(value = "delete/{uid}")
    public String processDeleteEventForm(@PathVariable int id, RedirectAttributes model) {

        Optional<Event> result = eventRepository.findById(id);
        if (result.isPresent()) {
            eventRepository.delete(result.get());
            model.addFlashAttribute(MESSAGE_KEY, "success|Event deleted");
            return "redirect:/events";
        } else {
            model.addFlashAttribute(MESSAGE_KEY, "danger|Event with ID does not exist: " +  id);
            return "redirect:/events";
        }
    }


}
