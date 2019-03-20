package dao;

import entity.Ingredient;

import java.sql.SQLException;
import java.util.List;

public interface IngredientDAO {

    void add(Ingredient ingredient);

    List<Ingredient> getAll();

    Ingredient getById(int id) ;

    List<Ingredient> getByRecipeId(int recipeId) ;


    void update(Ingredient ingredient) ;

    void delete(Ingredient ingredient) ;
}
