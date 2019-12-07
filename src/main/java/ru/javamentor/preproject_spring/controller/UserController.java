package ru.javamentor.preproject_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ModelAndView getUserPage(ModelAndView modelAndView) {
        modelAndView.setViewName("user");
        return modelAndView;
    }

}
