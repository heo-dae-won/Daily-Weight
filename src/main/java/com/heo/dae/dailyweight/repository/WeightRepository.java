package com.heo.dae.dailyweight.repository;

import com.heo.dae.dailyweight.domain.Weight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightRepository extends JpaRepository<Weight, Long> {

    public Weight getByDt(String dt);
}
