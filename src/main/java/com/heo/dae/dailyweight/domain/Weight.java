package com.heo.dae.dailyweight.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
public class Weight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String dt;
    int weight;

    @Override
    public String toString(){
        return "id >> " + id + ",date >> " + dt + ",weight >> " + weight;
    }
}
