package com.example.demo.controller;

import com.example.demo.service.FizzBuzzService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FizzBuzzPageController {

    private final FizzBuzzService fizzBuzzService;

    public FizzBuzzPageController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping("")
    public String home() {
        return "fizzbuzz";
    }

    @GetMapping("/page/fizzbuzz")
    public String fizzBuzz(@RequestParam("input") int input, Model model) {
        String result = fizzBuzzService.getFizzBuzzResult(input);
        model.addAttribute("result", result);
        return "fizzbuzz";
    }

}
