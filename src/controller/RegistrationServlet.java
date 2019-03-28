package controller;

import constants.Attribute;
import constants.PathToJsp;
import constants.PathToPage;
import entity.User;
import entity.UserCredentials;
import service.UserCredentialsService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(PathToPage.REGISTRATION_PATH)
public class RegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserCredentialsService userCredentialsService = new UserCredentialsService();
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(PathToJsp.REGISTRATION_PAGE_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter(Attribute.LOGIN);
        String password = request.getParameter(Attribute.PASSWORD);
        String username = request.getParameter(Attribute.NAME);
        String userSurname = request.getParameter(Attribute.SURNAME);


        if ((login != null) && (login.length()> 4)
                && (password != null) && (password.length()> 4) ){

            UserCredentials userCredentials = new UserCredentials(login, password);
            userCredentialsService.add(userCredentials);

            if (userCredentialsService.checkUserCredentials(login)) {
                userCredentials = userCredentialsService.getUserCredentials(login, password);

                userService.add(new User(username,userSurname), userCredentials.getId());

                response.sendRedirect(PathToPage.LOGIN_PATH);
            } else {
                request.getRequestDispatcher(PathToJsp.REGISTRATION_PAGE_JSP).forward(request, response);
            }

        }else {
            response.sendRedirect(PathToPage.REGISTRATION_PATH);
        }

    }


}

