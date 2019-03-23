package controller;

import connection.AuthUtils;
import constants.PathToJsp;
import constants.PathToPage;
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


@WebServlet(PathToPage.EDIT_RECIPE_PATH)
public class EditRecipeServlet extends HttpServlet {
    private RecipeService recipeService = new RecipeService();
    Recipe recipe = new Recipe();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (!AuthUtils.checkUserVerification(request)) {
            System.out.println("user not logined");
            response.sendRedirect(request.getContextPath() + PathToPage.LOGIN_PATH);
        } else {
             recipe =  recipeService.getById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("recipe",recipe);
            request.getRequestDispatcher(PathToJsp.EDIT_RECIPE_PAGE_JSP).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        recipe.setName(request.getParameter("recipeName"));
        recipe.setDescription(request.getParameter("instruction"));
        recipe.setCookingTime(Integer.parseInt(request.getParameter("cookTime")));
        recipe.setPreparationTime(Integer.parseInt(request.getParameter("prepTime")));

        HttpSession session = request.getSession();
        UserCredentials user = AuthUtils.getLoginedUser(session);


        System.out.println("Updated by " + user.getLogin());

        recipeService.update(recipe, user.getId());
        response.sendRedirect(PathToPage.HOME_PATH);


    }
}
