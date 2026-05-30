package org.example.healify.repository;

import org.example.healify.entity.HealthyRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthyRecipeRepository extends JpaRepository<HealthyRecipe, Long> {

    List<HealthyRecipe> findByCategory(String category);

    List<HealthyRecipe> findByRecipeNameContainingIgnoreCase(String recipeName);

    List<HealthyRecipe> findByHealthyTrue();

    List<HealthyRecipe> findByVeganTrue();

    List<HealthyRecipe> findByGlutenFreeTrue();

    List<HealthyRecipe> findByDifficulty(String difficulty);

    List<HealthyRecipe> findByCaloriesLessThanEqual(Integer maxCalories);

    List<HealthyRecipe> findTop5ByOrderByCaloriesAsc();
}
