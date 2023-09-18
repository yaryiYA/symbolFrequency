package com.example.symbolfrequency.service;


import com.example.symbolfrequency.entity.Frequency;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static junit.framework.TestCase.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FrequencyServiceTest {

    @Autowired
    private FrequencyService frequencyService;

    @Test
    public void testCalculateFrequency() {

        List<Frequency> frequencies = frequencyService.calculateFrequency("aaaaabcccc");


        Frequency a = new Frequency('a', 5);
        Frequency b = new Frequency('b', 1);
        Frequency c = new Frequency('c', 4);
        List<Frequency> list  = List.of(a,b,c);
        List<Frequency> result = list.stream().sorted(Comparator.comparingInt(Frequency::getFrequency)).toList();

        assertEquals(result, frequencies);
    }
}