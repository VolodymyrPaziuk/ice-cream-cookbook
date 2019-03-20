package service;

import connection.DBConnection;
import dao.RecipeHasIngredientsDAO;
import entity.RecipeHasIngredient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecipeHasIngredientsService implements RecipeHasIngredientsDAO {

    @Override
    public void add(int recipeId, int ingredientId) {
        String query = "INSERT INTO recipes_has_ingredients (recipes_id, ingredients_id) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, recipeId);
            preparedStatement.setInt(2, ingredientId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<RecipeHasIngredient> getAll() {

        String query = "SELECT * FROM recipes_has_ingredients";

        List<RecipeHasIngredient> recipeHasIngredientsList = new ArrayList<>();
        try {
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                RecipeHasIngredient recipeHasIngredients = new RecipeHasIngredient();

                recipeHasIngredients.setRecipeId(resultSet.getInt("recipes_id"));
                recipeHasIngredients.setRecipeId(resultSet.getInt("ingredients_id"));
                recipeHasIngredientsList.add(recipeHasIngredients);
            }
        } catch (SQLException e) {
            System.out.println("Cant read list from DB");
        }

        return recipeHasIngredientsList;
    }

    @Override
    public List<RecipeHasIngredient> getByRecipeId(int recipeId) {
        String query = "SELECT * FROM recipes_has_ingredients WHERE recipes_id = ?";

        List<RecipeHasIngredient> listOfIngredients = new ArrayList<>();
        try {
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                RecipeHasIngredient recipeHasIngredients = new RecipeHasIngredient();
                recipeHasIngredients.setRecipeId(resultSet.getInt("recipes_id"));
                recipeHasIngredients.setRecipeId(resultSet.getInt("ingredients_id"));
                listOfIngredients.add(recipeHasIngredients);
            }
        } catch (SQLException e) {
            System.out.println("Cant read list of ingredients from DB");
        }
        return listOfIngredients;
    }

    @Override
    public void update(RecipeHasIngredient recipeHasIngredient) {

    }

    @Override
    public void remove(int recipeId, int ingredientId) {

    }

    @Override
    public void removeIngredientsByRecipe(int recipeId) {


    }
}
