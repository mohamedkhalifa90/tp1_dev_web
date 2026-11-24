package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import listeners.SessionUser;
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        HttpSession session = request.getSession();

        SessionUser sessionUser = new SessionUser(username);
        session.setAttribute("user", sessionUser);        

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<h2>Welcome " + username + "!</h2>");
        out.println("<p>You are successfully logged in.</p>");
        out.println("<a href='items.html'>Go to Items</a>");
    }
}