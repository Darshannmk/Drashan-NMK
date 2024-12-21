package com.fitness.tracker.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private String mealName;
    private int calories;
    private float protein;
    private float carbs;
    private float fat;
    private Date date;

    // Getters and Setters
}
