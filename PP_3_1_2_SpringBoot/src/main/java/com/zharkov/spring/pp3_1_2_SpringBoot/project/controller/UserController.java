package com.zharkov.spring.pp3_1_2_SpringBoot.project.controller;

import com.zharkov.spring.pp3_1_2_SpringBoot.project.model.User;
import com.zharkov.spring.pp3_1_2_SpringBoot.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUser(Model users) {
        users.addAttribute("users", userService.getAllUser());
        return "home";
    }

    @GetMapping("/new")
    public String saveUserGet(@ModelAttribute("user") User user) {
        return "newuser";
    }

    @PostMapping("/save")
    public String saveUserPost(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    /*@DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }*/
    @RequestMapping("/delete")
    public String deleteUserById(@RequestParam long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
    @RequestMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/User";
    }
    /*    @GetMapping("/edit/{id}")
        public String userEditorGet(Model user, @PathVariable("id") Long id) {
            user.addAttribute("user", userService.getUserById(id));
            return "usereditor";
        }*/
    @RequestMapping("/edit")
    public String userEditorGet(@RequestParam long id, Model user) {
        user.addAttribute("user", userService.getUserById(id));
        return "usereditor";
    }
/*    @PostMapping("/{id}")
    public String userEditorPatch(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.userEditor(user, id);
        return "redirect:/users";
    }*/
}
