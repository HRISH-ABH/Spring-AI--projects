package com.hrishabh.springaiproject.controller;

import com.hrishabh.springaiproject.service.ChatService;
import com.hrishabh.springaiproject.service.RecipeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;


    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;

    }

    @GetMapping ("/generateRecipe")
    public String generateRecipe(@RequestParam String ingredients, @RequestParam String cuisine) {
        return recipeService.getRecipe(ingredients, cuisine);

    }
}
