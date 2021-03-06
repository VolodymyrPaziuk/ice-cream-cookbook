package controller;

import connection.AuthUtils;
import constants.PathToPage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(PathToPage.LOGOUT_PATH)
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        HttpSession session = request.getSession(false);
        if(session != null)
            session.invalidate();
        AuthUtils.deleteUserCookie(response);

        response.sendRedirect(PathToPage.LOGIN_PATH);
    }

}
