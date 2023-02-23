package com.example.demo.controller;

import com.example.demo.service.FizzBuzzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping(("/api/v1/fizzbuzz"))
public class FizzBuzzRestController {

    private final FizzBuzzService fizzBuzzService;

    public FizzBuzzRestController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping("/{input}")
    public ResponseEntity<String> fizzBuzz(@PathVariable int input) {
        log.info("Reached: /api/v1/fizzbuzz/{}",input);
        return new ResponseEntity<>(fizzBuzzService.getFizzBuzzResult(input), HttpStatus.OK);
    }
}
