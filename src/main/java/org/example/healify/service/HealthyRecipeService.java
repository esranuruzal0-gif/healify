package org.example.healify.service;

import org.example.healify.dto.HealthyRecipeDto;
import org.example.healify.entity.HealthyRecipe;
import org.example.healify.repository.HealthyRecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthyRecipeService {

    private final HealthyRecipeRepository repository;

    public HealthyRecipeService(HealthyRecipeRepository repository) {
        this.repository = repository;
    }

    public List<HealthyRecipe> getAllRecipes() {
        return repository.findAll();
    }

    public HealthyRecipe getRecipeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarif bulunamadi: " + id));
    }

    public HealthyRecipe createRecipe(HealthyRecipeDto dto) {
        return repository.save(mapToEntity(dto));
    }

    public HealthyRecipe updateRecipe(Long id, HealthyRecipeDto dto) {
        HealthyRecipe existing = getRecipeById(id);
        updateEntityFromDto(existing, dto);
        return repository.save(existing);
    }

    public void deleteRecipe(Long id) {
        getRecipeById(id);
        repository.deleteById(id);
    }

    public List<HealthyRecipe> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<HealthyRecipe> searchByName(String name) {
        return repository.findByRecipeNameContainingIgnoreCase(name);
    }

    public List<HealthyRecipe> getHealthyRecipes() {
        return repository.findByHealthyTrue();
    }

    public List<HealthyRecipe> getVeganRecipes() {
        return repository.findByVeganTrue();
    }

    public List<HealthyRecipe> getGlutenFreeRecipes() {
        return repository.findByGlutenFreeTrue();
    }

    public List<HealthyRecipe> getByDifficulty(String difficulty) {
        return repository.findByDifficulty(difficulty);
    }

    public List<HealthyRecipe> getByMaxCalories(Integer maxCalories) {
        return repository.findByCaloriesLessThanEqual(maxCalories);
    }

    public List<HealthyRecipe> getLowCalorieTop5() {
        return repository.findTop5ByOrderByCaloriesAsc();
    }

    private HealthyRecipe mapToEntity(HealthyRecipeDto dto) {
        HealthyRecipe recipe = new HealthyRecipe();
        updateEntityFromDto(recipe, dto);
        return recipe;
    }

    private void updateEntityFromDto(HealthyRecipe recipe, HealthyRecipeDto dto) {
        recipe.setRecipeName(dto.getRecipeName());
        recipe.setCategory(dto.getCategory());
        recipe.setCalories(dto.getCalories());
        recipe.setPreparationTime(dto.getPreparationTime());
        recipe.setIngredients(dto.getIngredients());
        recipe.setInstructions(dto.getInstructions());
        recipe.setHealthy(dto.getHealthy());
        recipe.setProtein(dto.getProtein());
        recipe.setCarbohydrate(dto.getCarbohydrate());
        recipe.setFat(dto.getFat());
        recipe.setVegan(dto.getVegan());
        recipe.setGlutenFree(dto.getGlutenFree());
        recipe.setDifficulty(dto.getDifficulty());
        recipe.setImageUrl(dto.getImageUrl());
    }
}
