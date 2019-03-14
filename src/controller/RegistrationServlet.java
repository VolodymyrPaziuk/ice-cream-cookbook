package controller;

import constants.Attribute;
import constants.Path;
import entity.UserCredentials;
import service.UserCredentialsService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserCredentialsService userCredentialsService = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(Path.REGISTRATION_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if ((request.getParameter(Attribute.LOGIN) != null) && !(request.getParameter(Attribute.LOGIN).isEmpty())
                && (request.getParameter(Attribute.PASSWORD) != null) && !(request.getParameter(Attribute.PASSWORD).isEmpty())) {


            UserCredentials userCredentials = new UserCredentials(request.getParameter(Attribute.LOGIN), request.getParameter(Attribute.PASSWORD));

            //
            System.out.println(userCredentials.toString());
            //

            userCredentialsService = new UserCredentialsService();


            if (userCredentialsService.checkUserCredentials(request.getParameter(Attribute.LOGIN))) {
                userCredentialsService.add(userCredentials);
                response.sendRedirect(Path.LOGIN_PAGE);
            } else {
                request.getRequestDispatcher(Path.REGISTRATION_PAGE).forward(request, response);
            }

        }


        // redirect to home/main
        // response.sendRedirect(request.getContextPath() + "/home");

        //super.doPost(request, response);
    }


}

