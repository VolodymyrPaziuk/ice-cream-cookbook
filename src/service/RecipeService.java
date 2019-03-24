package service;

import connection.DBConnection;
import dao.RecipeDAO;
import entity.Recipe;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class RecipeService implements RecipeDAO {

    @Override
    public void add(Recipe recipe, int user_id) {
        String query = "INSERT INTO recipes (name, description, cook_time, prep_time,image_url, user_id) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)) {

            preparedStatement.setString(1, recipe.getName());
            preparedStatement.setString(2, recipe.getDescription());
            preparedStatement.setInt(3, recipe.getCookingTime());
            preparedStatement.setInt(4, recipe.getPreparationTime());
            preparedStatement.setString(5, recipe.getImage());
            preparedStatement.setInt(6, user_id);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Recipe> getAll() {
        String query = "SELECT id,name,description,cook_time,prep_time,image_url FROM recipes";

        List<Recipe> listRecipes = new ArrayList<>();
        try {
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Recipe recipe = new Recipe();
                recipe.setId(resultSet.getInt("id"));
                recipe.setName(resultSet.getString("name"));
                recipe.setDescription(resultSet.getString("description"));
                recipe.setCookingTime(resultSet.getInt("cook_time"));
                recipe.setPreparationTime(resultSet.getInt("prep_time"));
                recipe.setImage(resultSet.getString("image_url"));
                listRecipes.add(recipe);
            }
        } catch (SQLException e) {
            System.out.println("Cant read list of recipes from DB");
        }

        return listRecipes;
    }

    @Override
    public List<Recipe> getAllByUserId(int user_id) {
        String query = "SELECT * FROM recipes WHERE user_id = ?";

        List<Recipe> recipeList = new ArrayList<>();

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(5, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Recipe recipe = new Recipe();
                recipe.setId(resultSet.getInt("id"));
                recipe.setName(resultSet.getString("name"));
                recipe.setDescription(resultSet.getString("description"));
                recipe.setCookingTime(resultSet.getInt("cook_time"));
                recipe.setPreparationTime(resultSet.getInt("prep_time"));
                recipe.setImage(resultSet.getString("image_url"));
                recipeList.add(recipe);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        return recipeList;
    }

    @Override
    public List<Recipe> getRecipesWithIngredients(String ingredients) {
        List<Recipe> recipeList = new ArrayList<>();
        int ingredientsCount = ingredients.split(",").length;
        String query = "SELECT * FROM recipes JOIN recipes_has_ingredients ON (recipes.id=recipes_has_ingredients.recipes_id)" +
                " WHERE ingredients_id in (" + ingredients + ")    GROUP BY recipes_has_ingredients.recipes_id " +
                "HAVING COUNT(*) = " + ingredientsCount + " ;";
        try {
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Recipe recipe = new Recipe();
                recipe.setId(resultSet.getInt("id"));
                recipe.setName(resultSet.getString("name"));
                recipe.setDescription(resultSet.getString("description"));
                recipe.setPreparationTime(resultSet.getInt("prep_time"));
                recipe.setCookingTime(resultSet.getInt("cook_time"));
                recipe.setImage(resultSet.getString("image_url"));
                recipeList.add(recipe);
            }
        } catch (SQLException e) {
            System.out.println("Cant read list of recipes from DB");
        }
        return recipeList;


    }

    @Override
    public List<Recipe> getRecipesByIngredients(String ingredients) {
        List<Recipe> recipeList = new ArrayList<>();
        int ingredientsCount = ingredients.split(",").length;
        String query = "SELECT  * FROM recipes JOIN recipes_has_ingredients ON (recipes.id=recipes_has_ingredients.recipes_id)" +
                " WHERE ingredients_id in (" + ingredients + ")" +
                " and  recipes_id in (select recipes_id from recipes_has_ingredients group by recipes_id" +
                " having count(ingredients_id)= " + ingredientsCount + " )group by recipes_id;";


        try {
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Recipe recipe = new Recipe();
                recipe.setId(resultSet.getInt("id"));
                recipe.setName(resultSet.getString("name"));
                recipe.setDescription(resultSet.getString("description"));
                recipe.setPreparationTime(resultSet.getInt("prep_time"));
                recipe.setCookingTime(resultSet.getInt("cook_time"));
                recipe.setImage(resultSet.getString("image_url"));
                recipeList.add(recipe);
            }
        } catch (SQLException e) {
            System.out.println("Cant read list of recipes from DB");
        }
        return recipeList;
    }

    @Override
    public Recipe getByUserId(int user_id) {

        String query = "Select * from recipes where user_id = ? ";

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Recipe recipe = new Recipe();
                recipe.setId(resultSet.getInt("id"));
                recipe.setName(resultSet.getString("name"));
                recipe.setDescription(resultSet.getString("description"));
                recipe.setCookingTime(resultSet.getInt("cook_time"));
                recipe.setPreparationTime(resultSet.getInt("prep_time"));
                recipe.setImage(resultSet.getString("image_url"));
                return recipe;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Recipe getById(int id) {
        String query = "Select * from recipes where id = ? ";

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Recipe recipe = new Recipe();
                recipe.setId(resultSet.getInt("id"));
                recipe.setName(resultSet.getString("name"));
                recipe.setDescription(resultSet.getString("description"));
                recipe.setCookingTime(resultSet.getInt("cook_time"));
                recipe.setPreparationTime(resultSet.getInt("prep_time"));
                recipe.setImage(resultSet.getString("image_url"));
                return recipe;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Recipe recipe) {

    }

    @Override
    public void update(Recipe recipe, int user_id) {
        System.out.println("in update method" + recipe.toString());
        System.out.println("recipe" + user_id);
        String query = "UPDATE recipes SET name = ?, description = ?, cook_time = ?, prep_time = ?, image_url = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)) {

            preparedStatement.setString(1, recipe.getName());
            preparedStatement.setString(2, recipe.getDescription());
            preparedStatement.setInt(3, recipe.getCookingTime());
            preparedStatement.setInt(4, recipe.getPreparationTime());
            preparedStatement.setString(5, recipe.getImage());
            preparedStatement.setInt(6, user_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void delete(int recipeId) {
        String query = "DELETE  FROM recipes where recipes.id = ? ";
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1,recipeId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
