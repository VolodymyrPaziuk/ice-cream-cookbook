package controller;

import connection.AuthUtils;
import constants.Path;
import entity.Recipe;
import entity.UserCredentials;
import service.RecipeService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(Path.HOME_PATH)
public class CookBookServlet extends HttpServlet {
    RecipeService recipeService = new RecipeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        UserCredentials loginedUserCredentials = AuthUtils.getLoginedUser(session);

        if (loginedUserCredentials == null) {
            response.sendRedirect(request.getContextPath() + Path.LOGIN_PATH);

        } else {
            List<Recipe> recipeList = recipeService.getAll();
            request.setAttribute("recipes", recipeList);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Path.HOME_PAGE_JSP);
            requestDispatcher.forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
