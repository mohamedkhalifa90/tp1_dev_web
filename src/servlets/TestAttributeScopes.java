package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestAttributeScopes")
public class TestAttributeScopes extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();

        // Application scope
        context.setAttribute("testApp", "Value1");
        context.setAttribute("testApp", "Value2");
        context.removeAttribute("testApp");

        // Request scope
        request.setAttribute("testRequest", "Value1");
        request.setAttribute("testRequest", "Value2");
        request.removeAttribute("testRequest");

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(
                "<h1>Attribute listeners tested!</h1>");
    }
}