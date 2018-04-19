package ota;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FirmwareInfoController {

    @GetMapping("/firmwareinfo")
    public String firmwareInfoForm(Model model) {
        model.addAttribute("firmwareinfo", new FirmwareInfo());
        return "firmwareinfo";
    }

    @PostMapping("/firmwareinfo")
    public String firmwareInfoSubmit(@ModelAttribute FirmwareInfo firmwareInfo) {
        return "result";
    }

}