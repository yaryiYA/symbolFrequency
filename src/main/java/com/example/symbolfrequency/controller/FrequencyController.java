package com.example.symbolfrequency.controller;

import com.example.symbolfrequency.entity.Frequency;
import com.example.symbolfrequency.service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/frequency")
public class FrequencyController {

    private final FrequencyService frequencyService;

    @Autowired
    public FrequencyController(FrequencyService frequencyService) {
        this.frequencyService = frequencyService;
    }

    @PostMapping
    public List<Frequency> calculateFrequency(@RequestParam("text") String text) {
        return frequencyService.calculateFrequency(text);
    }
}
