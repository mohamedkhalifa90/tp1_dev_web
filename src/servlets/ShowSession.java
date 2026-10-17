package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowSession extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Show Session</title></head>");
        out.println("<body>");

        String fullName = (String) session.getAttribute("fullName");

        if (fullName == null) {

            out.println("<h1>Welcome</h1>");
            out.println("<p>Please enter your information:</p>");

            out.println("<form action='ShowSession' method='POST'>");

            out.println("Full name: ");
            out.println("<input type='text' name='fullName' required>");
            out.println("<br><br>");

            out.println("Date of birth: ");
            out.println("<input type='date' name='birthDate' required>");
            out.println("<br><br>");

            out.println("<input type='submit' value='Submit'>");

            out.println("</form>");

        } else {

            LocalDate birthDate =
                LocalDate.parse((String) session.getAttribute("birthDate"));

            LocalDate today = LocalDate.now();

            LocalDate nextBirthday =
                birthDate.withYear(today.getYear());

            if (nextBirthday.isBefore(today)) {
                nextBirthday = nextBirthday.plusYears(1);
            }


            
            long days = java.time.temporal.ChronoUnit.DAYS.between(
                today, nextBirthday
            );

            out.println("<h1>Hi, " + fullName + "!</h1>");

            out.println("<p>There are " + days
                + " days to your birthday.</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        String fullName = request.getParameter("fullName");
        String birthDate = request.getParameter("birthDate");

        session.setAttribute("fullName", fullName);
        session.setAttribute("birthDate", birthDate);

        response.sendRedirect("ShowSession");
    }
}