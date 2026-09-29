package com.nikita.meal_planner_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikita.meal_planner_backend.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}