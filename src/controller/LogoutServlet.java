package controller;

import connection.AuthUtils;
import constants.Attribute;
import constants.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(Path.LOGOUT_PATH)
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if(session != null)
            session.invalidate();
        AuthUtils.deleteUserCookie(response);

        response.sendRedirect(Path.LOGIN_PATH);
    }

}
