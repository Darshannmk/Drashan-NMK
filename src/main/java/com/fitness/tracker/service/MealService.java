package com.fitness.tracker.service;

import com.fitness.tracker.model.Meal;
import com.fitness.tracker.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;

    public List<Meal> getAllMeals(int userId) {
        return mealRepository.findByUserId(userId);
    }

    public Meal addMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public Meal updateMeal(int id, Meal meal) {
        Meal existingMeal = mealRepository.findById(id).orElse(null);
        if (existingMeal != null) {
            existingMeal.setMealName(meal.getMealName());
            existingMeal.setCalories(meal.getCalories());
            existingMeal.setProtein(meal.getProtein());
            existingMeal.setCarbs(meal.getCarbs());
            existingMeal.setFat(meal.getFat());
            existingMeal.setDate(meal.getDate());
            return mealRepository.save(existingMeal);
        }
        return null;
    }

    public void deleteMeal(int id) {
        mealRepository.deleteById(id);
    }
}
