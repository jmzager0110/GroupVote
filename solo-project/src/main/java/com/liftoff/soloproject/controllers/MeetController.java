package com.liftoff.soloproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class MeetController {
        @RequestMapping(value="")

        public String index(){
            return "Hello World";
        }

        @GetMapping("/")
        public String tempGet(){
            return "Hello World";
        }

        @PostMapping("/")
        public String tempPost(){
            return  "Hello World";
        }
    }

//TODO: login.html & register.html is using <form method="post">

