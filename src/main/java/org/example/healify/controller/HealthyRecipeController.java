package org.example.healify.controller;

import jakarta.validation.Valid;
import org.example.healify.dto.HealthyRecipeDto;
import org.example.healify.entity.HealthyRecipe;
import org.example.healify.service.HealthyRecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class HealthyRecipeController {

    private final HealthyRecipeService service;

    public HealthyRecipeController(HealthyRecipeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<HealthyRecipe>> getAllRecipes() {
        return ResponseEntity.ok(service.getAllRecipes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthyRecipe> getRecipeById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRecipeById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<HealthyRecipe>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(service.searchByName(name));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<HealthyRecipe>> getByCategory(@PathVariable String category) {
        return ResponseEntity.ok(service.getByCategory(category));
    }

    @GetMapping("/healthy")
    public ResponseEntity<List<HealthyRecipe>> getHealthyRecipes() {
        return ResponseEntity.ok(service.getHealthyRecipes());
    }

    @GetMapping("/vegan")
    public ResponseEntity<List<HealthyRecipe>> getVeganRecipes() {
        return ResponseEntity.ok(service.getVeganRecipes());
    }

    @GetMapping("/gluten-free")
    public ResponseEntity<List<HealthyRecipe>> getGlutenFreeRecipes() {
        return ResponseEntity.ok(service.getGlutenFreeRecipes());
    }

    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<HealthyRecipe>> getByDifficulty(@PathVariable String difficulty) {
        return ResponseEntity.ok(service.getByDifficulty(difficulty));
    }

    @GetMapping("/max-calories")
    public ResponseEntity<List<HealthyRecipe>> getByMaxCalories(@RequestParam Integer value) {
        return ResponseEntity.ok(service.getByMaxCalories(value));
    }

    @GetMapping("/low-calorie-top5")
    public ResponseEntity<List<HealthyRecipe>> getLowCalorieTop5() {
        return ResponseEntity.ok(service.getLowCalorieTop5());
    }

    @PostMapping
    public ResponseEntity<HealthyRecipe> createRecipe(@Valid @RequestBody HealthyRecipeDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createRecipe(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthyRecipe> updateRecipe(@PathVariable Long id, @Valid @RequestBody HealthyRecipeDto dto) {
        return ResponseEntity.ok(service.updateRecipe(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        service.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }
}
