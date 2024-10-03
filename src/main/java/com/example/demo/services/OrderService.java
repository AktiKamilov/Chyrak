package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.models.Order;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    public final UserRepository userRepository;
    public final OrderRepository orderRepository;

    public void saveOrder(Principal principal, Order order) throws IOException {
        order.setUser(getUserByPrincipal(principal));
        log.info("Saving new Order. Title: {}; Desired data: {}", order.getTitle(), order.getDesiredData());
        orderRepository.save(order);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }
}
