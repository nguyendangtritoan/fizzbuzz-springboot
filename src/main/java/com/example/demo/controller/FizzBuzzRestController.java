package com.example.demo.controller;

import com.example.demo.service.FizzBuzzService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(("/api/v1/fizzbuzz"))
public class FizzBuzzRestController {

    private final FizzBuzzService fizzBuzzService;

    public FizzBuzzRestController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping("/{input}")
    public ResponseEntity<String> fizzBuzz(@PathVariable int input) {
        return new ResponseEntity<>(fizzBuzzService.getFizzBuzzResult(input), HttpStatus.OK);
    }
}
