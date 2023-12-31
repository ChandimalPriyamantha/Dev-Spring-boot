package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

    @Controller
    public class CountdownController {

        @GetMapping("/")
        public String countdown(Model model) {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime newYear = LocalDateTime.of(now.getYear() + 1, 1, 1, 0, 0);
            long seconds = ChronoUnit.SECONDS.between(now, newYear);
            model.addAttribute("seconds", seconds);
            return "index";
        }
    }


