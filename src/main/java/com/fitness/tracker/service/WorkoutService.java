package com.fitness.tracker.service;

import com.fitness.tracker.model.Workout;
import com.fitness.tracker.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {
    @Autowired
    private WorkoutRepository workoutRepository;

    public List<Workout> getAllWorkouts(int userId) {
        return workoutRepository.findByUserId(userId);
    }

    public Workout addWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public Workout updateWorkout(int id, Workout workout) {
        Workout existingWorkout = workoutRepository.findById(id).orElse(null);
        if (existingWorkout != null) {
            existingWorkout.setWorkoutType(workout.getWorkoutType());
            existingWorkout.setDuration(workout.getDuration());
            existingWorkout.setCaloriesBurned(workout.getCaloriesBurned());
            existingWorkout.setDate(workout.getDate());
            return workoutRepository.save(existingWorkout);
        }
        return null;
    }

    public void deleteWorkout(int id) {
        workoutRepository.deleteById(id);
    }
}
