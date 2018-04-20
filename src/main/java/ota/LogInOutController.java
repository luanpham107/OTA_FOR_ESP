package ota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ota.AppUser;
import ota.UserRepository;

import java.util.Iterator;
import java.util.Optional;

@Controller
public class LogInOutController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String loginCheck(@RequestParam String name, @RequestParam String password, Model model) {
        model.addAttribute("user", new AppUser());
        String temp = "Your name is: " + name + " password: " + password;
        System.out.println(temp);
        return "login";
    }

    /*@PostMapping("/login")
    public String loginCheck(@ModelAttribute User myUser) {
        return "login";
    }*/

    @GetMapping("/login")
    public String loginRequest(Model model) {
        model.addAttribute("user", new AppUser());
        return "login";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<AppUser> getAlUser() {
        return userRepository.findAll();
    }
}
