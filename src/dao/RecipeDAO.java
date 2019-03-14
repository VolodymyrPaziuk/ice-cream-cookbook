package dao;

import entity.Recipe;

import java.sql.SQLException;
import java.util.List;

public interface RecipeDAO {

    void add(Recipe recipe);

    List<Recipe> getAll();

    Recipe getById(int id);

    void update(Recipe recipe);

    void delete(Recipe recipe);
}
