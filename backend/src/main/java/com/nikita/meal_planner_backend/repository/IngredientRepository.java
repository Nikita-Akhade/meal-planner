package com.nikita.meal_planner_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikita.meal_planner_backend.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}