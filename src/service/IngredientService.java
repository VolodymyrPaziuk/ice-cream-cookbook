package service;

import connection.DBConnection;
import dao.IngredientDAO;
import entity.Ingredient;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public List<Ingredient> getAll() throws SQLException {
        return null;
    }

    @Override
    public Ingredient getById(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(Ingredient ingredient) throws SQLException {

    }

    @Override
    public void delete(Ingredient ingredient) throws SQLException {

    }


}
