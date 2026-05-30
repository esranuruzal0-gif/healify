package org.example.healify.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "healthy_recipes")
public class HealthyRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recipeName;
    private String category;
    private Integer calories;
    private Integer preparationTime;

    @Column(columnDefinition = "TEXT")
    private String ingredients;

    @Column(columnDefinition = "TEXT")
    private String instructions;

    private Boolean healthy;
    private Integer protein;
    private Integer carbohydrate;
    private Integer fat;
    private Boolean vegan;
    private Boolean glutenFree;
    private String difficulty;
    private String imageUrl;

    public HealthyRecipe() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRecipeName() { return recipeName; }
    public void setRecipeName(String recipeName) { this.recipeName = recipeName; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Integer getCalories() { return calories; }
    public void setCalories(Integer calories) { this.calories = calories; }
    public Integer getPreparationTime() { return preparationTime; }
    public void setPreparationTime(Integer preparationTime) { this.preparationTime = preparationTime; }
    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }
    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }
    public Boolean getHealthy() { return healthy; }
    public void setHealthy(Boolean healthy) { this.healthy = healthy; }
    public Integer getProtein() { return protein; }
    public void setProtein(Integer protein) { this.protein = protein; }
    public Integer getCarbohydrate() { return carbohydrate; }
    public void setCarbohydrate(Integer carbohydrate) { this.carbohydrate = carbohydrate; }
    public Integer getFat() { return fat; }
    public void setFat(Integer fat) { this.fat = fat; }
    public Boolean getVegan() { return vegan; }
    public void setVegan(Boolean vegan) { this.vegan = vegan; }
    public Boolean getGlutenFree() { return glutenFree; }
    public void setGlutenFree(Boolean glutenFree) { this.glutenFree = glutenFree; }
    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
