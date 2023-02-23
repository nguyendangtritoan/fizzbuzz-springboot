package com.example.demo.service;

import com.example.demo.model.FizzBuzzEnum;
import com.example.demo.model.Rule;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {
    private final List<Rule> rules = List.of(new Rule(3, FizzBuzzEnum.FIZZ), new Rule(5, FizzBuzzEnum.BUZZ));

    @Value(value = "${input.ceiling.value}")
    private int ceiling;

    @Override
    public String getFizzBuzzResult(int input) {
        log.info("getFizzBuzzResult() call: {}",input);
        if (input <= 0) {
            return "Input value must be greater than 0";
        }
        if (input > ceiling) {
            return "Input value must be smaller than "+ceiling;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= input; i++) {
            boolean ruleMet = false;
            for (Rule r : rules) {
                if (r.isDivisible(i)) {
                    result.append(r.getWord().label);
                    ruleMet = true;
                }
            }
            if (!ruleMet) {
                result.append(i);
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}
