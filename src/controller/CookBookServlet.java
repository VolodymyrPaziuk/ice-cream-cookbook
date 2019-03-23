package controller;

import connection.AuthUtils;

import constants.PathToJsp;
import constants.PathToPage;
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

@WebServlet(PathToPage.HOME_PATH)
public class CookBookServlet extends HttpServlet {
    RecipeService recipeService = new RecipeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserCredentials loginedUserCredentials = AuthUtils.getLoginedUser(session);

        List<Recipe> recipeList = recipeService.getAll();
        request.setAttribute("recipes", recipeList);

        if(loginedUserCredentials== null){
            System.out.println("User Nulll");
            request.getRequestDispatcher(PathToJsp.LOGIN_PAGE_JSP).forward(request, response);
            return;
        }

        if (loginedUserCredentials.isAdmin()) {
            System.out.println("Is ADMIIINNN");
            request.getRequestDispatcher(PathToJsp.HOME_ADMIN_PAGE_JSP).forward(request, response);
        } else {
            System.out.println("NotAdmin");
             request.getRequestDispatcher(PathToJsp.HOME_PAGE_JSP).forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
