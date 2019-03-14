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

public class RecipeService implements RecipeDAO {

    @Override
    public void add(Recipe recipe) {
        String query = "INSERT INTO recipes (name, description, cook_time, prep_time) VALUES (?,?,?,?)";

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query)) {

            preparedStatement.setString(1, recipe.getName());
            preparedStatement.setString(2, recipe.getDescription());
            preparedStatement.setInt(3, recipe.getCookingTime());
            preparedStatement.setInt(4, recipe.getPreparationTime());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Recipe> getAll() {
        String query = "SELECT * FROM recipes";
        List<Recipe> listRecipes = new ArrayList<Recipe>();
        try {
            Statement statement = DBConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                listRecipes.add(new Recipe(resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("cook_time"),
                        resultSet.getInt("prep_time")));
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Cant read list of clients from DB");
        }

        return listRecipes;
    }

    //ToDo: add implementation
    @Override
    public Recipe getById(int id) {

        return null;
    }

    @Override
    public void update(Recipe recipe) {


    }

    @Override
    public void delete(Recipe recipe) {

    }
}
