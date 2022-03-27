package com.heo.dae.dailyweight.service;

import com.heo.dae.dailyweight.domain.Weight;
import com.heo.dae.dailyweight.repository.WeightRepository;
import org.springframework.stereotype.Service;

@Service
public class WeightService {

    private final WeightRepository weightRepository;

    public WeightService(WeightRepository weightRepository){
        this.weightRepository = weightRepository;
    }

    public Weight getById(Long id){
//        return new Weight();
        return weightRepository.getById(id);
    }

    public Weight getByDate(String date){
        return weightRepository.getByDt(date);
    }

    public Weight save(Weight weight){
        return weightRepository.save(weight);
    }



}
