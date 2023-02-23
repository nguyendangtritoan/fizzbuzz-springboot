package com.example.demo;

import com.example.demo.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

@WebMvcTest
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FizzBuzzService service;

    @Test
    void testValidInput() throws Exception {
        when(service.getFizzBuzzResult(anyInt())).thenReturn("number!");
        mockMvc.perform(get("/api/v1/fizzbuzz/100"))
                .andExpect(status().isOk())
                .andExpect(content().string("number!"));
        verify(service, times(1)).getFizzBuzzResult(100);
    }
}
