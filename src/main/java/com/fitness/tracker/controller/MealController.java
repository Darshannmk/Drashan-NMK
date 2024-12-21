package com.fitness.tracker.controller;

import com.fitness.tracker.model.Meal;
import com.fitness.tracker.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meals")
public class MealController {
    @Autowired
    private MealService mealService;

    @GetMapping("/{userId}")
    public List<Meal> getAllMeals(@PathVariable int userId) {
        return mealService.getAllMeals(userId);
    }

    @PostMapping
    public Meal addMeal(@RequestBody Meal meal) {
        return mealService.addMeal(meal);
    }

    @PutMapping("/{id}")
    public Meal updateMeal(@PathVariable int id, @RequestBody Meal meal) {
        return mealService.updateMeal(id, meal);
    }

    @DeleteMapping("/{id}")
    public void deleteMeal(@PathVariable int id) {
        mealService.deleteMeal(id);
    }
}
