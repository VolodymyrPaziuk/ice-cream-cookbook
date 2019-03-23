package controller;

import connection.AuthUtils;
import constants.Attribute;
import constants.PathToJsp;
import constants.PathToPage;
import entity.UserCredentials;
import service.UserCredentialsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(PathToPage.LOGIN_PATH)
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(PathToJsp.LOGIN_PAGE_JSP);
        requestDispatcher.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String rememberMeStr = request.getParameter("rememberMe");
        boolean remember = "Y".equals(rememberMeStr);
        UserCredentials userCredentials = null;
        boolean isLogined = false;

        //  if (checkLoginValidation(request.getParameter(Attribute.LOGIN), request.getParameter(Attribute.PASSWORD))) {

        UserCredentialsService userCredentialsService = new UserCredentialsService();
        userCredentials = userCredentialsService.getUserCredentials(request.getParameter(Attribute.LOGIN), request.getParameter(Attribute.PASSWORD));

        if (userCredentials != null) {
            System.out.println("Mutherfucker is logined");

            AuthUtils.storeLoginedUser(request.getSession(), userCredentials);

            if (remember) {
                AuthUtils.storeUserCookie(response, userCredentials);
            } else {
                AuthUtils.deleteUserCookie(response);
            }

            response.sendRedirect(PathToPage.HOME_PATH);

        } else {
            request.setAttribute(Attribute.ERROR, "Invalid login or password");
            request.getRequestDispatcher(PathToJsp.LOGIN_PAGE_JSP).forward(request, response);

        }


    }


    private boolean checkLoginValidation(String login, String password) {
        return login != null && password != null
                && login.length() > 3 && password.length() > 3;


    }
}

