package controller;

import constants.PathToPage;
import service.RecipeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PathToPage.DELETE_RECIPE_PATH)
public class DeleteServlet extends HttpServlet {
    private RecipeService recipeService = new RecipeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        recipeService.delete(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect(PathToPage.HOME_PATH);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
