package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookie extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        String firstName = "";
        String lastName = "";
        String birthDay = "";
        String sex = "";

        if (cookies != null) {

            for (Cookie cookie : cookies) {

                if (cookie.getName().equals("firstName")) {
                    firstName = cookie.getValue();
                }

                if (cookie.getName().equals("LastName")) {
                    lastName = cookie.getValue();
                }

                if (cookie.getName().equals("birthDay")) {
                    birthDay = cookie.getValue();
                }

                if (cookie.getName().equals("Sex")) {
                    sex = cookie.getValue();
                }
            }
        }

        out.println("<html>");
        out.println("<head><title>Read Cookies</title></head>");
        out.println("<body>");

        out.println("<h1>Cookies Information</h1>");

        out.println("<table border='1'>");

        out.println("<tr>");
        out.println("<th>Cookie</th>");
        out.println("<th>Value</th>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>First Name</td>");
        out.println("<td>" + firstName + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Last Name</td>");
        out.println("<td>" + lastName + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Birth Day</td>");
        out.println("<td>" + birthDay + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Sex</td>");
        out.println("<td>" + sex + "</td>");
        out.println("</tr>");

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }
}