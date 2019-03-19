package controller;

import connection.AuthUtils;
import constants.Path;
import entity.User;
import entity.UserCredentials;
import service.UserCredentialsService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(Path.USER_INFO)
public class UserInfoServlet extends HttpServlet {

    User user = new User();
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        UserCredentials loginedUserCredentials = AuthUtils.getLoginedUser(session);

        if (loginedUserCredentials == null) {
            response.sendRedirect(request.getContextPath() + Path.LOGIN_PATH);
            return;
        }


         user = userService.getUser(loginedUserCredentials.getId());

        System.out.println("User " + user.toString());
        System.out.println("UserCredentials " + loginedUserCredentials.toString());

        request.setAttribute("user", user);

        getServletContext().getRequestDispatcher(Path.USER_INFO_JSP).forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         user.setName(request.getParameter("userName"));
         user.setSurname(request.getParameter("userSurname"));
        System.out.println("User in doPost");

        userService.update(user);
        response.sendRedirect(Path.HOME_PATH);

    }
}
