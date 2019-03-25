package controller;

import connection.AuthUtils;
import constants.PathToJsp;
import constants.PathToPage;
import entity.Ingredient;
import entity.Recipe;
import entity.UserCredentials;
import service.IngredientService;
import service.RecipeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(PathToPage.SEARCH_RECIPE_PATH)
public class SearchRecipeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (AuthUtils.getLoginedUser(request.getSession()) == null) {
            response.sendRedirect(request.getContextPath() + PathToPage.LOGIN_PATH);
        } else {
            IngredientService ingredientService = new IngredientService();
            List<Ingredient> ingredientList = ingredientService.getAll();

            request.setAttribute("ingredientList", ingredientList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PathToJsp.SEARCH_RECIPE_PAGE_JSP);
            requestDispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String ingredients = request.getParameter("selectedIngredients");

        RecipeService recipeService = new RecipeService();
        List<Recipe>  recipeList = new ArrayList<>();

        recipeList = recipeService.getRecipesByIngredients(ingredients);
        System.out.println(recipeList.toString());
        System.out.println(ingredients);


        request.setAttribute("recipes", recipeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(PathToJsp.SEARCH_RESULT_PAGE_JSP);
        requestDispatcher.forward(request, response);

    }


}
