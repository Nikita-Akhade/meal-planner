package com.nikita.meal_planner_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "recipe_ingredients")
@Data
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private Double quantity;
}