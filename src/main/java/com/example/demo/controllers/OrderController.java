package com.example.demo.controllers;


import com.example.demo.models.Order;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.security.Principal;

@Controller
@Slf4j
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/contacts/submit")
    public String submit(Principal principal, String title, String desired_data, String email, String wishes) throws IOException {
        Order order = new Order(title, desired_data, email, wishes);
        orderService.saveOrder(principal, order);
        return "over";
    }
}
