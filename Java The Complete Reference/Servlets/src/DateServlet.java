import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class DateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<b>");

        Date date = (Date) session.getAttribute("date");

        if (date != null) {
            out.print("Last access date: " + date + "<br>");
        }

        date = new Date();
        session.setAttribute("date", date);
        out.println("Current date: " + date);

        out.close();
    }
}
