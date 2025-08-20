package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "addUser";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String name,
                          @RequestParam int age,
                          @RequestParam String gender,
                          @RequestParam (required = false, defaultValue = "false") boolean marriage) {
        userService.addUser(name, age, gender, marriage);
        return "redirect:/";
    }
    @GetMapping("/edit")
    public String showEditForm(@RequestParam int id, Model model) {
        List<User> allUsers = userService.getAllUsers();
        User userToEdit = null;
        for (User u : allUsers) {
            if (u.getId() == id) {
                userToEdit = u;
                break;
            }
        }
        model.addAttribute("user", userToEdit);
        return "editUser";
    }

    @PostMapping("/edit")
    public String editUser(@RequestParam int id,
                           @RequestParam String name,
                           @RequestParam int age,
                           @RequestParam String gender,
                           @RequestParam (required = false, defaultValue = "false") boolean marriage) {
        userService.changeUser(id, name, age, gender, marriage);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
