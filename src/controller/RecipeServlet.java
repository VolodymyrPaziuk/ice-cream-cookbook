package controller;

import constants.Path;
import entity.Ingredient;
import entity.Recipe;
import service.IngredientService;
import service.RecipeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(Path.RECIPE_PATH)
public class RecipeServlet extends HttpServlet {
   private RecipeService recipeService = new RecipeService();
    private IngredientService ingredientService = new IngredientService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Recipe recipe =  recipeService.getById(Integer.parseInt(request.getParameter("id")));
        List<Ingredient> ingredientList = ingredientService.getByRecipeId(recipe.getId());

        request.setAttribute("recipe",recipe);
        request.setAttribute("ingredientList", ingredientList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Path.RECIPE_PAGE_JSP);
        requestDispatcher.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
