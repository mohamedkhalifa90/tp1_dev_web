package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RemoveSessionUser")
public class RemoveSessionUser extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            session.removeAttribute("user");
            response.getWriter().println("User removed from session!");
        } else {
            response.getWriter().println("No user found in session.");
        }
    }
}