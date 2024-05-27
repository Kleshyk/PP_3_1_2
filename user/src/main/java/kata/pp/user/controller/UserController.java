package kata.pp.user.controller;

import kata.pp.user.model.User;
import kata.pp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

private UserService userService;

@Autowired
public UserController(UserService userService) {
    this.userService = userService;
}

@GetMapping("/")
public String getAllUsers(Model model) {
    model.addAttribute("users", userService.getAllUsers());
    return "users";
}

@GetMapping("/updateUser")
public String getUserById(@RequestParam("id") Long id, Model model) {
    model.addAttribute(userService.getUserById(id));
    return "updateUser";
}

@GetMapping("/create")
public String newUser(@ModelAttribute("user") User user) {
    return "create";
}


@PostMapping
public String addUser(@ModelAttribute("user") User user) {
    userService.saveUser(user);
    return "redirect:/";
}

@PostMapping("/updateUser")
public String updateUser(@ModelAttribute("user") User user) {
    userService.updateUser(user);
    return "redirect:/";
}

@PostMapping("/delete")
public String deleteUser(@RequestParam("id") Long id) {
    userService.deleteUser(id);
    return "redirect:/";
}
}
