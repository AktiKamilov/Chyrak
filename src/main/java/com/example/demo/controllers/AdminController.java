package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class AdminController {

    private final UserService userService; // Сервис для работы с пользователями

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    // 1. Отображение списка всех пользователей
    @GetMapping("/admin")
    public String showUsersList(Model model) {
        List<User> users = userService.findAllUsers(); // Получение списка пользователей
        model.addAttribute("users", users); // Передача списка пользователей на страницу
        return "admin"; // Возвращаем шаблон admin-users.html
    }

    // 2. Отображение детальной информации о пользователе по ID
    @GetMapping("/admin/user/{id}")
    public String showUserDetails(@PathVariable Long id, Model model) {
        User user = userService.findUserById(id); // Поиск пользователя по ID
        if (user != null) {
            model.addAttribute("user", user); // Передача данных пользователя в шаблон
            return "admin-user-details"; // Возвращаем шаблон admin-user-details.html
        } else {
            return "redirect:/admin/users"; // Если пользователь не найден, возвращаемся к списку
        }
    }
}
