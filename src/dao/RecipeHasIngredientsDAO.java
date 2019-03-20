package dao;

import entity.RecipeHasIngredient;

import java.util.List;

public interface RecipeHasIngredientsDAO {

    void add(int recipeId, int ingredientId);

    List<RecipeHasIngredient> getAll();

    List<RecipeHasIngredient> getByReciprId(int recipeId);

    void update(RecipeHasIngredient recipeHasIngredient);

    void remove(int recipeId, int ingredientId);

    void removeIngredientsByRecipe (int recipeId);
}
