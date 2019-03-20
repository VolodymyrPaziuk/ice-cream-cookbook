package entity;

public class RecipeHasIngredient {
    private int recipeId;
    private int ingredientId;

    public RecipeHasIngredient(){}

    public RecipeHasIngredient(int recipeId, int ingredientId) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
    }

    @Override
    public String toString() {
        return "RecipeHasIngredient{" +
                "recipeId=" + recipeId +
                ", ingredientId=" + ingredientId +
                '}';
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }
}
