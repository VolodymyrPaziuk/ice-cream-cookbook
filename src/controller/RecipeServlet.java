package controller;

import connection.AuthUtils;
import constants.PathToJsp;
import constants.PathToPage;
import entity.Ingredient;
import entity.Recipe;
import entity.UserCredentials;
import service.IngredientService;
import service.RecipeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(PathToPage.RECIPE_PATH)
public class RecipeServlet extends HttpServlet {
   private RecipeService recipeService = new RecipeService();
    private IngredientService ingredientService = new IngredientService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Recipe recipe =  recipeService.getById(Integer.parseInt(request.getParameter("id")));
        List<Ingredient> ingredientList = ingredientService.getByRecipeId(recipe.getId());

        request.setAttribute("recipe",recipe);
        request.setAttribute("ingredientList", ingredientList);

        HttpSession session = request.getSession();
        UserCredentials loginedUserCredentials = AuthUtils.getLoginedUser(session);

        if (loginedUserCredentials.isAdmin()){
            request.getRequestDispatcher(PathToJsp.RECIPE_ADMIN_PAGE_JSP).forward(request, response);
        }else {
            request.getRequestDispatcher(PathToJsp.RECIPE_PAGE_JSP).forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
