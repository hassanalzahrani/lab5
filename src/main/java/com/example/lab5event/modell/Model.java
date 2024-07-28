package com.example.lab5event.modell;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Model {
    private String id;
    private String description;
    private int capacity;
    private String starDate;
    private String endDate;
}
