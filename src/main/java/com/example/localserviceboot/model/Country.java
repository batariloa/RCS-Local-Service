package com.example.localserviceboot.model;


import lombok.Data;

@Data
public class Country {

    private String name;

    Country(String name){
        this.name = name;
    }
}
