package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequiredArgsConstructor
public class MainController {
    @GetMapping("/")
    public String web() {
        return "web";
    }
    @GetMapping("/web")
    public String webb() {
        return "web";
    }
   @GetMapping("/about")
    public String about() {
        return "about";
    }
    @GetMapping("/trails")
    public String trails() {
        return "trails";
    }
    @GetMapping("/contacts")
    public String contacts() {
        return "contacts";
    }
}
