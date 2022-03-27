package com.heo.dae.dailyweight.controller;

import com.heo.dae.dailyweight.domain.Weight;
import com.heo.dae.dailyweight.service.WeightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeightController {

    private final WeightService weightService;

    public WeightController(WeightService weightService){
        this.weightService = weightService;
    }

    @GetMapping("/weight/{id}")
    public Weight getWeight(@PathVariable Long id){
        return weightService.getById(id);
    }

    @GetMapping("/weight/date/{date}")
    public Weight getWeightByDate(@PathVariable String date){
        System.out.println(String.format("YYYY-MM-DD", date));

//        weightService.getByDate(date);

        return new Weight();
    }

    @GetMapping("/save")
    public Weight save(){
        Weight weight = new Weight();
        weight.setWeight(50);
        weight.setDt("2022-03-27");

        return weightService.save(weight);
    }
}
