package com.nikita.meal_planner_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikita.meal_planner_backend.model.RecipeIngredient;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
}