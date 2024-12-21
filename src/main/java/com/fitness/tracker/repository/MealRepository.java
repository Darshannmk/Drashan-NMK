package com.fitness.tracker.repository;

import com.fitness.tracker.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {
    List<Meal> findByUserId(int userId);
}
