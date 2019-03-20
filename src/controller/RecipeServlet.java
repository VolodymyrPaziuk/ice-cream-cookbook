package controller;

import constants.Path;
import entity.Recipe;
import service.RecipeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Path.RECIPE_PATH)
public class RecipeServlet extends HttpServlet {
   RecipeService recipeService = new RecipeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Recipe recipe =  recipeService.getById(Integer.parseInt(request.getParameter("id")));

        request.setAttribute("recipe",recipe);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Path.RECIPE_PAGE_JSP);
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
