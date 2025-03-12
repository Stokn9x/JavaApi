package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") //Har lavet cors her
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public User getUser(@RequestParam Integer id){
        Optional user = userService.getUser(id);
        if(user.isPresent()){
            return (User) user.get();
        }
        return null;
    }

    @GetMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        Optional<User> user = userService.authenticate(email, password);
        return user.isPresent() ? "Login successful! Welcome, " + user.get().getName() : "Invalid credentials";
    }

}
