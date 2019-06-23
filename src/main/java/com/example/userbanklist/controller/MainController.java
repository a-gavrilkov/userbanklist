package com.example.userbanklist.controller;

import com.example.userbanklist.entity.User;
import com.example.userbanklist.service.AccountService;
import com.example.userbanklist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@Controller
@RequestMapping("")
public class MainController {

    private UserService userService;
    private AccountService accountService;

    @Autowired
    public MainController(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @GetMapping("")
    protected String doGet() throws ServletException, IOException {
        return "index";
    }

    @PostMapping("")
    protected String doPost(
            @RequestParam String method,
            @RequestParam String richestVal,
            @RequestParam String sumVal,
            ModelMap model
    ) {
        if (Objects.equals(method, "richest")) {
            try {
                User user = userService.getRichestUser();
                model.addAttribute("richest", String.format("%s %s", user.getName(), user.getSureName()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            model.addAttribute("sum", sumVal);
        } else if (Objects.equals(method,"sum")) {
            try {
                model.addAttribute("sum", accountService.getSumOfAllAccounts());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            model.addAttribute("richest", richestVal);
        }
        return "index";
    }
}
