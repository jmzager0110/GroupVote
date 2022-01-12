package com.liftoff.soloproject.controllers;

import com.liftoff.soloproject.User;
import com.liftoff.soloproject.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
//@RequestMapping(value = "access")
public class MeetController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Title");
        return "index";
    }
    //TODO: Add hasErrors method
    @GetMapping(value = "login")
    public String showLoginForm(Model model, User user) {
        model.addAttribute("username", userRepository.findByEmail(""));
        model.addAttribute("password", user.getPassword());
        return "login";
    }

    @GetMapping(value = "register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    //TODO: Verify this is salting properly
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "register_success";
    }
    //TODO: Refactor this method once the event model is designed
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = (List<User>) userRepository.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }
}

//TODO: Refactor users.html to events.html? Or preserve for function within Events?
//TODO: html files from the tutorial more complex, see notes.txt for ideas

