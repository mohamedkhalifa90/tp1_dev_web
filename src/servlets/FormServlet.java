package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDate = request.getParameter("birthDate");
        String sex = request.getParameter("sex");
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("LastName", lastName);
        Cookie birthDayCookie = new Cookie("birthDay", birthDate);
        Cookie sexCookie = new Cookie("Sex", sex);
        response.addCookie(firstNameCookie);
        response.addCookie(lastNameCookie);
        response.addCookie(birthDayCookie);
        response.addCookie(sexCookie);

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Person Information</title></head>");
        out.println("<body>");

        out.println("<h1>Person Information</h1>");

        out.println("<table border='1'>");

        out.println("<tr>");
        out.println("<th>First Name</th>");
        out.println("<th>Last Name</th>");
        out.println("<th>Birth Date</th>");
        out.println("<th>Sex</th>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>" + firstName + "</td>");
        out.println("<td>" + lastName + "</td>");
        out.println("<td>" + birthDate + "</td>");
        out.println("<td>" + sex + "</td>");

        out.println("</tr>");

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }
}