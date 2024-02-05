
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Operation.Account_holder_operation;
import Operation.connection;
import Customers.Client;
import Customers.account_holder;
import java.math.BigDecimal;
import javax.servlet.http.HttpSession;
import Operation.Transaction;

public class Transfer_amount extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Transaction Complete Logo</title>");
//            out.println("<style>");
//            out.println("body {");
//            out.println("    display: flex;");
//            out.println("    align-items: center;");
//            out.println("    justify-content: center;");
//            out.println("    height: 100vh;");
//            out.println("    margin: 0;");
//            out.println("    background-color: #f0f0f0;");
//            out.println("}");
//            out.println(".logo-container {");
//            out.println("    text-align: center;");
//            out.println("    font-family: 'Arial', sans-serif;");
//            out.println("    color: #2ecc71; /* Green color */");
//            out.println("}");
//            out.println(".icon-checkmark {");
//            out.println("    font-size: 60px;");
//            out.println("    margin-bottom: 20px;");
//            out.println("}");
//            out.println(".message {");
//            out.println("    font-size: 20px;");
//            out.println("    font-weight: bold;");
//            out.println("}");
//            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
//            out.println("    <div class=\"logo-container\">");
//            out.println("        <div class=\"icon-checkmark\">✓</div>");
//            out.println("        <div class=\"message\">Transaction Complete</div>");
//            out.println("    </div>");
            HttpSession session = request.getSession(true);
            String id = (String) (session.getAttribute("NetbankingId"));
            account_holder ah = new account_holder();
            account_holder ah1 = new account_holder();
            Account_holder_operation aho = new Account_holder_operation();
            ah = aho.getaccountholder(id);
            Long accountno, balance;
            accountno = Long.parseLong(request.getParameter("benificary"));
            balance=Long.parseLong(request.getParameter("amount"));
            long ownerbalance = ah.getBalance();
            out.println(ah.getAccount_no());
            long withdrawamount = ownerbalance - balance;
            ah1 = aho.benificarydetail(accountno);
            long fetchedbalance = ah1.getBalance();
            long finalamount = fetchedbalance + balance;
            Transaction tn=new Transaction();
            tn.maintainTransaction(ah.getAccount_no(), accountno, balance, "Debit",finalamount);
            if (aho.updatebalance(withdrawamount, ah.getAccount_no())&& aho.updatebalance(finalamount, accountno))
            {
                response.sendRedirect("TransactionComplete.html");
            } else {
                out.println("<h1>Transaction failed</h1>");
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
