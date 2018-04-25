package io.innopolis.products.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ApplicationController {

    private static Logger logger = LogManager.getLogger(ApplicationController.class);

    @GetMapping("/")
    public String index() {
        logger.info("Index page is reached");
        return "index";
    }


    @GetMapping("/login")
    public String login() {
        logger.info("Login page is reached");
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        logger.info("Registration page is reached");
        return "register";
    }


}
