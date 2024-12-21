package com.fitness.tracker.controller;

import com.fitness.tracker.model.Workout;
import com.fitness.tracker.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {
    @Autowired
    private WorkoutService workoutService;

    @GetMapping("/{userId}")
    public List<Workout> getAllWorkouts(@PathVariable int userId) {
        return workoutService.getAllWorkouts(userId);
    }

    @PostMapping
    public Workout addWorkout(@RequestBody Workout workout) {
        return workoutService.addWorkout(workout);
    }

    @PutMapping("/{id}")
    public Workout updateWorkout(@PathVariable int id, @RequestBody Workout workout) {
        return workoutService.updateWorkout(id, workout);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable int id) {
        workoutService.deleteWorkout(id);
    }
}
