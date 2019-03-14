package connection;

import entity.UserCredentials;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;

public class AuthUtils {
    public static final String ATTRIBUTE_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";

    private static final String ATTRIBUTE_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATTRIBUTE_NAME_CONNECTION, conn);
    }

    public static Connection getStoredConnection(ServletRequest request) {
        Connection conn = (Connection) request.getAttribute(ATTRIBUTE_NAME_CONNECTION);
        return conn;
    }

    public static void storeLoginedUser(HttpSession session, UserCredentials loginedUser) {
        session.setAttribute("loginedUser", loginedUser);
    }

    public static UserCredentials getLoginedUser(HttpSession session) {
        UserCredentials loginedUser = (UserCredentials) session.getAttribute("loginedUser");
        return loginedUser;
    }

    public static void storeUserCookie(HttpServletResponse response, UserCredentials userCredentials) {
        System.out.println("Store user cookie");
        Cookie cookieUserName = new Cookie(ATTRIBUTE_USER_NAME, userCredentials.getLogin());
        cookieUserName.setMaxAge( 60 * 60 * 1000);
        response.addCookie(cookieUserName);
    }

    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATTRIBUTE_USER_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void deleteUserCredentialsCookie(HttpServletResponse response) {
        Cookie cookieUserCredentialsName = new Cookie(ATTRIBUTE_USER_NAME, null);
        cookieUserCredentialsName.setMaxAge(0);
        response.addCookie(cookieUserCredentialsName);
    }

}
