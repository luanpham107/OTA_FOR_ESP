package ota;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/a")
    public String login(@RequestParam(name="firstName") String name, Model model) {
        model.addAttribute("firstName", name);
        System.out.println(name);
        return "firmwareinfo";
    }

    @GetMapping("/info")
    public String info(){
        return "result";
    }

}
