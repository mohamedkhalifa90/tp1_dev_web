package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TestUserAttribute")
public class TestUserAttribute extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if ("replace".equals(action)) {
            session.setAttribute("user", "NewUser");
            response.getWriter().println("User attribute replaced!");

        } else if ("remove".equals(action)) {
            session.removeAttribute("user");
            response.getWriter().println("User attribute removed!");

        } else {
            response.getWriter().println("Unknown action.");
        }
    }
}