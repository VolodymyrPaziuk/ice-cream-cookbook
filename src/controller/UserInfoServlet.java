package controller;

import connection.AuthUtils;
import constants.PathToJsp;
import constants.PathToPage;
import entity.User;
import entity.UserCredentials;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(PathToPage.USER_INFO)
public class UserInfoServlet extends HttpServlet {
    User user = new User();
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserCredentials loginedUserCredentials = AuthUtils.getLoginedUser(session);

        if (loginedUserCredentials == null) {
            response.sendRedirect(request.getContextPath() + PathToPage.LOGIN_PATH);
            return;
        }

        user = userService.getUser(loginedUserCredentials.getId());
        boolean b = loginedUserCredentials.isAdmin();

        request.setAttribute("isAdmin",b);
        request.setAttribute("user", user);
        getServletContext().getRequestDispatcher(PathToJsp.USER_INFO_JSP).forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("doPost");
        user.setName(request.getParameter("userName"));
        user.setSurname(request.getParameter("userSurname"));
        userService.update(user);
        response.sendRedirect(PathToPage.HOME_PATH);

    }
}
