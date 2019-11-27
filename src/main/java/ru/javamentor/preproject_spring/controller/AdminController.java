package ru.javamentor.preproject_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.javamentor.preproject_spring.model.User;
import ru.javamentor.preproject_spring.service.UserService;
import java.util.List;

@Controller
public class AdminController{

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/admin", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView getAllUsers(){
            List<User> users = userService.getAllUsers();
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("admin");
            modelAndView.addObject("usersFromServer",users);
            return modelAndView;
    }

    @RequestMapping(path = "/admin/add", method = RequestMethod.GET)
    public ModelAndView showAddUserForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add");
        return modelAndView;
    }

    @RequestMapping(path = "/admin/add", method = RequestMethod.POST)
    public String addUser(User user) {
        return userService.addUser(user) ? "redirect:/admin" : "user_contains_already";
    }

    @RequestMapping(path = "/admin/edit", method = RequestMethod.POST)
    public ModelAndView showEditUserForm(User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("edit");
        return modelAndView;
    }

    @RequestMapping(path = "/admin/edit/save", method = RequestMethod.POST)
    public String saveModifiedUser(User user){
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(path = "/admin/delete", method = RequestMethod.POST)
    public String deleteUser(User user){
        userService.deleteUserById(user.getId());
        return "redirect:/admin";
    }
}
