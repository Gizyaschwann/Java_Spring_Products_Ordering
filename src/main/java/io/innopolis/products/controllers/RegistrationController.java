package io.innopolis.products.controllers;


import io.innopolis.products.dto.UserRegistrationDto;
import io.innopolis.products.models.User;
import io.innopolis.products.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private static Logger logger = LogManager.getLogger(OrdersController.class);

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        logger.info("Request for showing a registration form is done");
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result) {
        logger.info("Request for registring a user is done");

        User existing = userService.findByUsername(userDto.getUsername());
        if (existing != null) {
            logger.warn("User entered username that is already in use ");
            result.rejectValue("username", null, "This username is already used");
        }

        if (result.hasErrors()) {
            logger.warn("User entered invalid data");
            return "registration";
        }

        userService.save(userDto);
        logger.info("Registration of a user is done");
        return "redirect:/registration?success";
    }

}