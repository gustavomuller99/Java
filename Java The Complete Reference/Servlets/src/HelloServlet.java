import java.io.*;
import jakarta.servlet.*;

public class HelloServlet extends GenericServlet {

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<p>Hello!!</p>");
        out.close();
    }

}
