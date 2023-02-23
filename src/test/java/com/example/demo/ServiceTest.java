package com.example.demo;

import com.example.demo.service.FizzBuzzService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @ParameterizedTest
    @CsvSource(value =
            {"5, Buzz",
            "15, FizzBuzz",
            "33, Fizz"}
    )
    void checkFizzBuzzLastElement(int input, String expected) {
        assertThat(
                takeLastWord(
                        fizzBuzzService.getFizzBuzzResult(input)
                )
        ).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {15})
    void fizz_buzz_numbers_divisible_by_3_and_5(int input) {
        assertThat(fizzBuzzService.getFizzBuzzResult(input)).isEqualTo("1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz");
    }

    private String takeLastWord(String str) {
        String[] words = str.split(" ");
        return words[words.length-1];
    }
}
