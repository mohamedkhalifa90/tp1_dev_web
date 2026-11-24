package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VisitCounter extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        int visits = 0;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {

            for (Cookie cookie : cookies) {

                if (cookie.getName().equals("visits")) {
                    visits = Integer.parseInt(cookie.getValue());
                }
            }
        }

        visits++;

        Cookie visitCookie = new Cookie(
                "visits",
                String.valueOf(visits)
        );

        response.addCookie(visitCookie);

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Visit Counter</title></head>");
        out.println("<body>");

        out.println("<h1>Visit Counter</h1>");

        if (visits == 1) {
            out.println("<p>Welcome! This is your first visit.</p>");
        } else {
            out.println("<p>You have visited this page "
                    + visits + " times.</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}