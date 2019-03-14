package dao;

import entity.Ingredient;

import java.sql.SQLException;
import java.util.List;

public interface IngredientDAO {

    void add(Ingredient ingredient) ;

    List<Ingredient> getAll() throws SQLException;

    Ingredient getById(int id) throws SQLException;

    void update(Ingredient ingredient) throws SQLException;

    void delete(Ingredient ingredient) throws SQLException;
}
