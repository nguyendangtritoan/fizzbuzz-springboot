package com.example.demo.controller;

import com.example.demo.service.FizzBuzzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class FizzBuzzPageController {

    private final FizzBuzzService fizzBuzzService;

    public FizzBuzzPageController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping("")
    public String home() {
        log.info("Home page visited");
        return "fizzbuzz";
    }

    @GetMapping("/page/fizzbuzz")
    public String fizzBuzz(@RequestParam("input") int input, Model model) {
        log.info("Reached: /page/fizzbuzz with param {}",input);
        String result = fizzBuzzService.getFizzBuzzResult(input);
        model.addAttribute("result", result);
        return "fizzbuzz";
    }

}
