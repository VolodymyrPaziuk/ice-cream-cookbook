package controller;
import connection.AuthUtils;
import constants.Attribute;
import entity.UserCredentials;
import service.UserCredentialsService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
        RequestDispatcher view = request.getRequestDispatcher(redirectPage);
        view.forward(request, response); //forward response to request

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

            System.out.printf("in method");

                UserCredentialsService userCredentialsService = new UserCredentialsService();
            try {
                userCredentials = userCredentialsService.getUserCredentials(request.getParameter(Attribute.LOGIN), request.getParameter(Attribute.PASSWORD));
                System.out.println(userCredentials.toString());
            }catch(NullPointerException e){
                request.setAttribute(Attribute.ERROR, "Invalid login or password");
                request.getRequestDispatcher("login2.jsp").forward(request,response);
            }

                if (userCredentials != null) {
                    System.out.println("User Name and password is valid");
                    isLogined = true;
                }

        } else {
            isLogined = false;
            //Connection conn = MyUtils.getStoredConnection(request);
            //Connection conn = DBConnection.getConnection();
        }

        // If error, forward to /WEB-INF/views/loginView.jsp
        if (!isLogined) {
            userCredentials = new UserCredentials();
            userCredentials.setLogin(request.getParameter(Attribute.LOGIN));
            userCredentials.setPassword(request.getParameter(Attribute.PASSWORD));

            System.out.println("Error");
            // Store information in request attribute, before forward.
          //  request.setAttribute("errorString", errorString);
            request.setAttribute("user", userCredentials);

            // Forward to /WEB-INF/views/loginView.jsp
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login2.jsp");
            dispatcher.forward(request, response);
        }
        // If no error
        // Store user information in Session
        // And redirect to userInfo page.
        else {
            HttpSession session = request.getSession();
            AuthUtils.storeLoginedUser(session, userCredentials);

            //
            AuthUtils.storeUserCookie(response, userCredentials);

            // If user checked "Remember me".
           // if (remember) {
           //     MyUtils.storeUserCookie(response, user);
            }
            // Else delete cookie.
           // else {
           //     MyUtils.deleteUserCookie(response);
            //}

            // Redirect to userInfo page.
            //response.sendRedirect(request.getHeader("Referer"));
        }
    }

