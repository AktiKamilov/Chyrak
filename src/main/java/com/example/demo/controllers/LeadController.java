package com.example.demo.controllers;


import com.example.demo.models.Lead;
import com.example.demo.repositories.LeadRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LeadController {
    private final LeadRepository leadRepository;
    @PostMapping("/contacts/submit")
    public String submit(String name, String surname, String email, String message) throws IOException {
        Lead lead = new Lead(name, surname, email, message);
        log.info("Contact submitted");
        leadRepository.save(lead);
        return "over";
    }
}
