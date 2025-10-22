import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ColorGetServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String color = req.getParameter("color");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<b>The selected color is</b>");
        out.println("<p>" + color + "</p>");
        out.close();
    }
}
