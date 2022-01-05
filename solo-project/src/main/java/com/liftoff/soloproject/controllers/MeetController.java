package com.liftoff.soloproject.controllers;

import com.liftoff.soloproject.data.EventRepository;
import com.liftoff.soloproject.models.User;
import com.liftoff.soloproject.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@ResponseBody
public class MeetController {

    //Replaced by HomeController code from Chris Bay's Spring Security
    @Autowired
    EventRepository eventRepository;

//    @GetMapping(value = "/")
//    public String index(Model model) {
//        List<Event> allEvents = eventRepository.findAll();
//        model.addAttribute("events", allEvents);
//        return "events/list";
//    }

//    @Autowired
//    private UserRepository userRepository;
//
//
//    //TODO: Replace all mapping methods as files from tutorial removed.
//    @GetMapping("")
//    public String viewHomePage() {
//        return "index";
//    }
//
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new User());
//        return "signup_form";
//    }
//
//    @PostMapping("/process_register")
//    public String processRegister(User user) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//        userRepository.save(user);
//        return "register_success";
//    }
//
//    @GetMapping("/users")
//    public String listUsers(Model model) {
//        List<User> listUsers = (List<User>) userRepository.findAll();
//        model.addAttribute("listUsers", listUsers);
//
//        return "users";
//    }
}

//TODO: login.html & register.html is using <form method="post">
//TODO: html files from the tutorial far more complex, see notes.txt for ideas

