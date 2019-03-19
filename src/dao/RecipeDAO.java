package dao;

import entity.Recipe;

import java.sql.SQLException;
import java.util.List;

public interface RecipeDAO {

    void add(Recipe recipe, int user_id);

    List<Recipe> getAll();

    List<Recipe> getAllByUserId(int user_id);
    Recipe getByUserId(int user_id);

    void update(Recipe recipe);

    void delete(Recipe recipe);
}
