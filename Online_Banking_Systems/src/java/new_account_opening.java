/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Customers.account_holder;
import java.util.Date;
import Operation.Account_holder_operation;
import java.util.Random;

/**
 *
 * @author ASUS
 */
public class new_account_opening extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet new_account_opening</title>");  
            out.println("    <style>");
        out.println("        body {");
        out.println("            font-family: Arial, sans-serif;");
        out.println("            text-align: center;");
        out.println("            background-color: #f5f5f5;");
        out.println("        }");
        out.println("        .container {");
        out.println("            background-color: #fff;");
        out.println("            border-radius: 5px;");
        out.println("            padding: 20px;");
        out.println("            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
        out.println("            max-width: 400px;");
        out.println("            margin: 0 auto;");
        out.println("            margin-top: 100px;");
        out.println("        }");
         out.println("        h1 {");
        out.println("            color: #007bff;");
        out.println("        }");
        out.println("        button {");
        out.println("            background-color: #007bff;");
        out.println("            color: #fff;");
        out.println("            border: none;");
        out.println("            padding: 10px 20px;");
        out.println("            cursor: pointer;");
        out.println("            border-radius: 5px;");
        out.println("            font-size: 16px;");
        out.println("        }");
        out.println("        button:hover {");
        out.println("            background-color: #0056b3;");
        out.println("        }");
        out.println("    </style>");
            out.println("</head>");
            out.println("<body>");
             long account_no,balance;
            String firstname,lastname,address,phonenumber,account_holder,E_mail;
            firstname=request.getParameter("firstName");
            lastname=request.getParameter("lastName");
            address=request.getParameter("address");
            String date1=request.getParameter("dateOfBirth");
            phonenumber=request.getParameter("phoneNumber");
            account_holder=request.getParameter("accountType");
            E_mail=request.getParameter("email");
            Random rn=new Random();
            account_no=rn.nextLong(1000000000);
            account_holder ah=new account_holder();
            balance=0;
            ah.setFirstname(firstname);
            ah.setLastname(lastname);
            ah.setAddress(address);
            ah.setAcount_type(account_holder);
            ah.setDOB(date1);
            ah.setPhonenumber(phonenumber);
            ah.setE_mail(E_mail);
            ah.setAccount_no(account_no);
            ah.setBalance(balance);
            Account_holder_operation aho=new Account_holder_operation();
            aho.insert(ah);
           out.println("<div class=\"container\">");
        out.println("      <h1>Congratulations! Welcome to Our Bank</h1>");
        out.println("        <p>We're excited to have you as our valued customer.</p>");
        out.println("        <form action=index.html method=\"post\">");
        out.println("            <button type=\"submit\">Go to Our Portal</button>");
        out.println("        </form>");
        out.println("    </div>");
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
