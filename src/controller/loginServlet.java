package controller;

import connection.AuthUtils;
import constants.Attribute;
import constants.Path;
import entity.UserCredentials;
import service.UserCredentialsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Path.LOGIN_PAGE_JSP);
        requestDispatcher.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String rememberMeStr = request.getParameter("rememberMe");
        boolean remember = "Y".equals(rememberMeStr);


        UserCredentials userCredentials = null;
        boolean isLogined = false;

        if (request.getParameter(Attribute.LOGIN) != null && request.getParameter(Attribute.PASSWORD) != null) {

            UserCredentialsService userCredentialsService = new UserCredentialsService();
            userCredentials = userCredentialsService.getUserCredentials(request.getParameter(Attribute.LOGIN), request.getParameter(Attribute.PASSWORD));

            if (userCredentials != null) {
                System.out.println(userCredentials.toString());
                System.out.println("Mutherfucker is logined");

                HttpSession session = request.getSession();
                AuthUtils.storeLoginedUser(session, userCredentials);

                // If user checked "Remember me".
                if (remember) {
                    AuthUtils.storeUserCookie(response, userCredentials);
                } else {
                    AuthUtils.deleteUserCookie(response);
                }

                response.sendRedirect(Path.HOME_PATH);

            } else {
                request.setAttribute(Attribute.ERROR, "Invalid login or password");
                request.getRequestDispatcher(Path.LOGIN_PAGE_JSP).forward(request, response);


            }

        }


    }


}

