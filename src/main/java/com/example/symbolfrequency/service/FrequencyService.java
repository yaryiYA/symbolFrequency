package com.example.symbolfrequency.service;

import com.example.symbolfrequency.entity.Frequency;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FrequencyService {

    public List<Frequency> calculateFrequency(String text) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map.entrySet().stream()
                .map(e -> new Frequency(e.getKey(), e.getValue()))
                .sorted(Comparator.comparingInt(Frequency::getFrequency)).toList();
    }
}
