package connection;

import constants.Path;
import entity.UserCredentials;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;

public class AuthUtils {

    private static final String ATTRIBUTE_USER_NAME = "STORE_USER_IN_COOKIE_ATTRIBUTE";


    public static boolean checkUserVerification(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserCredentials loginedUserCredentials = AuthUtils.getLoginedUser(session);
        return loginedUserCredentials != null;
    }

    public static void storeLoginedUser(HttpSession session, UserCredentials loginedUser) {
        session.setAttribute("loginedUser", loginedUser);
    }

    public static UserCredentials getLoginedUser(HttpSession session) {
        return  (UserCredentials) session.getAttribute("loginedUser");
    }

    public static void storeUserCookie(HttpServletResponse response, UserCredentials userCredentials) {
        Cookie userCookie = new Cookie(ATTRIBUTE_USER_NAME, userCredentials.getLogin());
        userCookie.setMaxAge( 60 * 60 * 1000);
        response.addCookie(userCookie);
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

    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookieUserCredentialsName = new Cookie(ATTRIBUTE_USER_NAME, null);
        cookieUserCredentialsName.setMaxAge(0);
        response.addCookie(cookieUserCredentialsName);
    }

}
