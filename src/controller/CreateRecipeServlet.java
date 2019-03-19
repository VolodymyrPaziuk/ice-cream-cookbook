package controller;

import connection.AuthUtils;
import constants.Path;
import entity.Recipe;
import entity.UserCredentials;
import service.RecipeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/createRecipe")
public class CreateRecipeServlet extends HttpServlet {


    RecipeService recipeService = new RecipeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        UserCredentials loginedUserCredentials = AuthUtils.getLoginedUser(session);

        if (loginedUserCredentials == null) {
            response.sendRedirect(request.getContextPath() + Path.LOGIN_PATH);
            return;
        }
        request.getRequestDispatcher("/createRecipe.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int userId = AuthUtils.getLoginedUser(session).getId();
        String recipeName =  request.getParameter("recipeName");
        int prepTime =  Integer.parseInt(request.getParameter("prepTime"));
        int cookTime =  Integer.parseInt(request.getParameter("cookTime"));
        String instruction =  request.getParameter("instruction");
        Recipe recipe = new Recipe(recipeName,prepTime,cookTime,instruction);

        System.out.println(recipe.toString());
        System.out.println("user id is " + userId);
        recipeService.add(recipe,userId);
        request.getRequestDispatcher(Path.HOME_PATH).forward(request, response);
    }
}
