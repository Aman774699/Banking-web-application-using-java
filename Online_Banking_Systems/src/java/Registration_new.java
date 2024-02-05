
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Customers.Client;
import Operation.connection;
import Operation.Account_holder_operation;
import Customers.account_holder;

public class Registration_new extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registration</title>");
            out.println(" <style>\n"
                    + "        body {\n"
                    + "            font-family: Arial, sans-serif;\n"
                    + "            text-align: center;\n"
                    + "            background-color: #f2f2f2;\n"
                    + "        }\n"
                    + "\n"
                    + "        .container {\n"
                    + "            background-color: #ffffff;\n"
                    + "            border-radius: 5px;\n"
                    + "            padding: 20px;\n"
                    + "            margin: 100px auto;\n"
                    + "            width: 300px;\n"
                    + "        }\n"
                    + "\n"
                    + "        h1 {\n"
                    + "            color: #333;\n"
                    + "        }\n"
                    + "\n"
                    + "        #login-btn {\n"
                    + "            background-color: #0074d9;\n"
                    + "            color: #fff;\n"
                    + "            border: none;\n"
                    + "            padding: 10px 20px;\n"
                    + "            text-align: center;\n"
                    + "            text-decoration: none;\n"
                    + "            display: inline-block;\n"
                    + "            font-size: 16px;\n"
                    + "            margin: 10px 5px;\n"
                    + "            cursor: pointer;\n"
                    + "            border-radius: 5px;\n"
                    + "        }\n"
                    + "\n"
                    + "        #login-btn:hover {\n"
                    + "            background-color: #0056b3;\n"
                    + "        }\n"
                    + "    </style>");
            out.println("</head>");
            out.println("<body>");
            String username, password, email, confirmpass, fullname;
            username = request.getParameter("username");
            password = request.getParameter("password");
            email = request.getParameter("email");
            confirmpass = request.getParameter("confirm-password");
            fullname = request.getParameter("name");
            Client client = new Client();
            client.setNetBankingId(username);
            client.setUsername(username);
            client.setPassword(password);
            client.setConfirm_password(confirmpass);
            client.setEmail(email);
            client.setFull_name(fullname);
            connection co = new connection();
            Account_holder_operation aho = new Account_holder_operation();
            account_holder ah = new account_holder();
            ah.setE_mail(email);
            ah.setNet_banking(username);
            if (co.validuser(email, client)) {
                co.insertClient(client);
                co.loginClient(client);
                aho.updateNetBankingId(ah);
                out.println(" <div class=\"container\">\n"
                        + "        <h1>Registration Successful</h1>\n"
                        + "        <p>Your registration was successful. You can now log in.</p>\n"
                        + "        <a id=\"login-btn\" href=\"index.html\">Go to Login</a>\n"
                        + "    </div>");
            } else {
                out.print("Customer does not exist in our system Please Contact ur nearest branch...Thankyou");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
