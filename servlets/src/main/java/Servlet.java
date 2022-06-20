import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime ;
import java.time.format.DateTimeFormatter ;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
        resp.setContentType("text/html");

        LocalDateTime now = LocalDateTime.now() ;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/y");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:m:ss") ;

        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<h1>Date/time command servlet.</h1>");

        String command = req.getParameter("command");
        if (command != null) {

            if (command.equals("date")) {
                printWriter.write("<h2>Current date is "  + now.format(dateFormatter) + "</h2>");

            } else if (command.equals("time")) {
                printWriter.write("<h2>Current time is "  + now.format(timeFormatter) + "</h2>");

            } else {
                printWriter.write("<h2>Unknown command! Use time or date.</h2>");
            }

        } else {
            printWriter.write("<h2>Use '/servlet?command=time' or '/servlet?command=date'</h2>");
        }
        printWriter.close();
    }
}
