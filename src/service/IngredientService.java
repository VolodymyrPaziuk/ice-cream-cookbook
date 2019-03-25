package service;

import connection.DBConnection;
import dao.IngredientDAO;
import entity.Ingredient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IngredientService implements IngredientDAO {

    @Override
    public void add(Ingredient ingredient) {
        String query = "INSERT INTO ingredients (name) VALUES (?)";
        try(PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, ingredient.getName());
            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Ingredient> getAll()  {

        String query = "SELECT * FROM ingredients";

        List<Ingredient> listIngredient = new ArrayList<>();
        try {
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Ingredient ingredient = new Ingredient();
                ingredient.setId(resultSet.getInt("id"));
                ingredient.setName(resultSet.getString("name"));
                listIngredient.add(ingredient);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Cant read list of ingredients from db");
        }

        return listIngredient;
    }

    @Override
    public Ingredient getById(int id)  {
        return null;
    }


    @Override
    public List<Ingredient> getByRecipeId(int recipeId)  {
        List<Ingredient> ingredientsList = new ArrayList<>();
        String query = "SELECT *  FROM ingredients JOIN recipes_has_ingredients ON ingredients.id = recipes_has_ingredients.ingredients_id WHERE recipes_id =?";

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)){

            preparedStatement.setInt(1, recipeId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Ingredient ingredient = new Ingredient();
                ingredient.setId(resultSet.getInt("id"));
                ingredient.setName(resultSet.getString("name"));
                ingredientsList.add(ingredient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredientsList;
    }

    @Override
    public void update(Ingredient ingredient)   {

    }

    @Override
    public void delete(Ingredient ingredient)   {

    }


}
