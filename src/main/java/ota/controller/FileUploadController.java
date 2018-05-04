package ota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ExceptionHandler;


import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ota.model.DeviceInfo;

import ota.model.DeviceInfoRepository;
import ota.storage.StorageFileNotFoundException;
import ota.storage.StorageService;

@Controller
public class FileUploadController {
    private final StorageService storageService;

    @Autowired
    private DeviceInfoRepository deviceInfoRepository;

    @Autowired
    public FileUploadController(StorageService storageService){
        this.storageService = storageService;
    }

    @GetMapping("/firmwareinfo")
    public String firmwareInfoForm(Model model) {
        model.addAttribute("firmwareinfo", new DeviceInfo());
        model.addAttribute("messages", deviceInfoRepository.findAll());
        return "firmwareInfoPage";
    }

    @PostMapping("/firmwareinfo")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/firmwareinfo";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc){
        return ResponseEntity.notFound().build();
    }

}
