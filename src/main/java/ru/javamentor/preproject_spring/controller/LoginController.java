package ru.javamentor.preproject_spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginForm(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
