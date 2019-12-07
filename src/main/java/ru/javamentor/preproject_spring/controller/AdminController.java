package ru.javamentor.preproject_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.javamentor.preproject_spring.model.Role;
import ru.javamentor.preproject_spring.model.User;
import ru.javamentor.preproject_spring.service.RoleService;
import ru.javamentor.preproject_spring.service.UserService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService service, RoleService roleService) {
        this.userService = service;
        this.roleService = roleService;
    }

    @RequestMapping(path = "/admin", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getAllUsers(ModelAndView modelAndView) {
        List<User> users = userService.getAllUsers();
        modelAndView.setViewName("admin");
        modelAndView.addObject("usersFromServer", users);
        return modelAndView;
    }

    @RequestMapping(path = "/admin/add", method = RequestMethod.GET)
    public ModelAndView getAddUserPage(ModelAndView modelAndView) {
        modelAndView.setViewName("add");
        return modelAndView;
    }

    @RequestMapping(path = "/admin/add", method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "login") String login,
                          @RequestParam(value = "password") String password,
                          @RequestParam(value = "roleAdmin", required = false) String roleAdmin,
                          @RequestParam(value = "roleUser", required = false) String roleUser) {

        Set<Role> roles = createRoleSet(roleAdmin,roleUser);
        User user = new User(login, password, roles);
        return userService.addUser(user) ? "redirect:/admin" : "user_contains_already";
    }

    @RequestMapping(path = "/admin/edit", method = RequestMethod.POST)
    public ModelAndView getEditUserPage(@RequestParam(value = "login") String login,
                                        ModelAndView modelAndView) {
        User user = userService.getUserByLogin(login).get();
        Set<String> rolesNames = new HashSet<>();
        user.getRoles().forEach(e -> rolesNames.add(e.getRoleName()));
        modelAndView.addObject("user", user);
        modelAndView.addObject("rolesNames", rolesNames);
        modelAndView.setViewName("edit");
        return modelAndView;
    }

    @RequestMapping(path = "/admin/edit/save", method = RequestMethod.POST)
    public String saveModifiedUser(User user,
                                   @RequestParam(value = "roleAdmin", required = false) String roleAdmin,
                                   @RequestParam(value = "roleUser", required = false) String roleUser) {

        Set<Role> roles = createRoleSet(roleAdmin,roleUser);
        user.setRoles(roles);
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(path = "/admin/delete", method = RequestMethod.POST)
    public String deleteUser(User user) {
        userService.deleteUserById(user.getId());
        return "redirect:/admin";
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test() {
        return null;
    }

    private Set<Role> createRoleSet(String ... roleName) {
       return Stream.of(roleName).
                filter(Objects::nonNull).
                map(roleService::getRoleByName).
                filter(Optional::isPresent).
                map(Optional::get).
                collect(Collectors.toSet());
    }

}
