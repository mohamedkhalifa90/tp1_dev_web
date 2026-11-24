
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListItems extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        HashMap<String, Integer> items =
            (HashMap<String, Integer>) session.getAttribute("itemCounts");

        if (items == null) {
            items = new HashMap<String, Integer>();
        }

        String newItem = request.getParameter("newItem");

        if (newItem != null && !newItem.trim().isEmpty()) {

            newItem = newItem.trim();

            int count = items.getOrDefault(newItem, 0);

            items.put(newItem, count + 1);
        }

        session.setAttribute("itemCounts", items);

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>List Items</title></head>");
        out.println("<body>");

        out.println("<h1>My Items</h1>");
        out.println("<ul>");

        for (String item : items.keySet()) {
            out.println("<li>" + item + " : "
                + items.get(item) + " fois</li>");
        }

        out.println("</ul>");

        out.println("<a href='items.html'>Add another item</a>");

        out.println("</body>");
        out.println("</html>");
    }
}
