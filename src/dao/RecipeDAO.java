package dao;

import entity.Recipe;

import java.util.List;

public interface RecipeDAO {

    void add(Recipe recipe, int user_id);

    List<Recipe> getAll();

    List<Recipe> getAllByUserId(int user_id);

    Recipe getByUserId(int user_id);

    Recipe getById(int id);

    void update(Recipe recipe);

    void delete(Recipe recipe);
}
