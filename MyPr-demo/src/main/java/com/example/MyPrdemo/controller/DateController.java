package com.example.MyPrdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.MyPrdemo.service.DateService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DateController {
    @Autowired
    private DateService dateService;

    public DateController(DateService dateService) {
        this.dateService = dateService;
    }

    @GetMapping("/date")
    public String data(Model model) {
        model.addAttribute("date", dateService.getDate());
    return "date";
    }
}
