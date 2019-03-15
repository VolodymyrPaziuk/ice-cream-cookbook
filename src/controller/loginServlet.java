package controller;

import connection.AuthUtils;
import constants.Attribute;
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

        String redirectPage = "login2.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(redirectPage);
        requestDispatcher.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String rememberMeStr = request.getParameter("rememberMe");
        boolean remember = "Y".equals(rememberMeStr);


        UserCredentials userCredentials = null;
        boolean isLogined = false;
        System.out.println(request.getParameter(Attribute.LOGIN));
        System.out.println(request.getParameter(Attribute.PASSWORD));

        if (request.getParameter(Attribute.LOGIN) != null && request.getParameter(Attribute.PASSWORD) != null) {

            UserCredentialsService userCredentialsService = new UserCredentialsService();
            userCredentials = userCredentialsService.getUserCredentials(request.getParameter(Attribute.LOGIN), request.getParameter(Attribute.PASSWORD));
            //System.out.println(userCredentials.toString());

            if (userCredentials != null) {
                System.out.println(userCredentials.toString());

                isLogined = true;

                HttpSession session = request.getSession();
                AuthUtils.storeLoginedUser(session, userCredentials);

                // If user checked "Remember me".
                if (remember) {
                    AuthUtils.storeUserCookie(response, userCredentials);
                } else {
                    AuthUtils.deleteUserCookie(response);
                }

                response.sendRedirect(request.getHeader("Referer"));

            } else {
                isLogined = false;
                request.setAttribute(Attribute.ERROR, "Invalid login or password");
                request.getRequestDispatcher("login2.jsp").forward(request, response);
            }

        }


    }


}

