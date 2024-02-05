
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Customers.Client;
import Operation.connection;
import javax.servlet.http.HttpSession;
import Customers.account_holder;
import Operation.Account_holder_operation;

public class ClientLogin_new extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Client_Login</title>");
            out.println("</head>");
            out.println("<body>");
            String username, password;
            username = request.getParameter("NetBankingId");
            password = request.getParameter("password");
            Client c = new Client();
            connection co = new connection();
            Account_holder_operation aho = new Account_holder_operation();
            account_holder ah = aho.getaccountholder(username);
            if (co.check(username, password)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("NetbankingId", username);
                response.sendRedirect("Portal.jsp");
            }
            else {
                response.sendRedirect("index.html");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
