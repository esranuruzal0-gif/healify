package org.example.healify.repository;

import org.example.healify.entity.HealthyRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthyRecipeRepository extends JpaRepository<HealthyRecipe, Long> {

}