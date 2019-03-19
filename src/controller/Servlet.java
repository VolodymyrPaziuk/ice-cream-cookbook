package controller;
import entity.Ingredient;
import entity.Recipe;
import service.IngredientService;
import service.RecipeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/hello")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       IngredientService ingredientService = new IngredientService();
        List<Ingredient> ingredientList = ingredientService.getAll();
        System.out.println(ingredientList);
        request.setAttribute("ingredient",ingredientList);

        request.getRequestDispatcher("IngredTest.jsp").forward(request, response);

    }
}
