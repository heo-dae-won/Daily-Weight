package com.heo.dae.dailyweight.controller;

import com.heo.dae.dailyweight.domain.Weight;
import com.heo.dae.dailyweight.service.WeightService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@Testcontainers
@WebMvcTest(WeightController.class)
@WebAppConfiguration
class WeightControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    WeightController weightController;

    @MockBean
    WeightService weightService;

    @Test
    void getWeight() throws Exception {
        Weight weight = new Weight();
        weight.setId(1L);
        weight.setWeight(50);
        weight.setDt("20220301");

        Weight weight2 = new Weight();
        weight2.setId(2L);
        weight2.setWeight(100);
        weight2.setDt("20220310");

        given(weightService.getById(1L)).willReturn(weight);
        given(weightController.getWeight(1L)).willReturn(weight2);
//        weightController.getWeight(1L);

//        when(weightController.getWeight(1L)).thenReturn(weight);
//
//        assertEquals(weight, weightController.getWeight(1L));

        mvc.perform(get("/weight/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("20220310")));

        System.out.println(weightController.getWeight(1L));
        System.out.println(weightService.getById(1L));
    }

    @Test
    void getWeightByDate() {
    }

    @Test
    void save() {
    }
}