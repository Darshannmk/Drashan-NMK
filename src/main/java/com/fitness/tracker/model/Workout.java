package com.fitness.tracker.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private String workoutType;
    private int duration;
    private float caloriesBurned;
    private Date date;

    // Getters and Setters
}
