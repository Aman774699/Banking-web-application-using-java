<%-- 
    Document   : ConformPayment
    Created on : Nov 19, 2023, 1:37:25 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Operation.Account_holder_operation" %>
<%@page import="Customers.Client" %>
<%@page import="Operation.connection"%>
<%@page import=" javax.servlet.http.HttpSession"%>
<%@page import="Customers.account_holder"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <% try {
                session = request.getSession();
                String username = session.getAttribute("NetbankingId").toString();
                Account_holder_operation aho = new Account_holder_operation();
                account_holder ah = aho.getaccountholder(username);
                request.setAttribute("account_number", ah.getAccount_no());
                long account_number = ah.getAccount_no();
                String amount = request.getParameter("cardNumber");
                long amt=Long.parseLong(amount);
                Account_holder_operation aho1 = new Account_holder_operation();
              aho1.updatebalance(amt, account_number);
            } catch (Exception e) {
                out.println(e);
            }
        %>
    </body>
</html>
