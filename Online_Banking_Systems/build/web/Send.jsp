<%-- 
    Document   : Send
    Created on : Nov 18, 2023, 11:44:40 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Operation.Account_holder_operation" %>
<%@page import="Customers.Client" %>
<%@page import="Operation.connection"%>
<%@page import=" javax.servlet.http.HttpSession"%>
<%@page import="Customers.account_holder"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Payment Confirmation</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                display: flex;
                align-items: center;
                justify-content: center;
                height: 100vh;
            }

            .payment-container {
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding: 20px;
                width: 300px;
                text-align: center;
            }

            .input-box {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            .confirm-button {
                background-color: #4caf50;
                color: #fff;
                padding: 10px 15px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
            }

            .confirm-button:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <div class="payment-container">
                        <form method="post" action="ConformPayment.jsp">
            <label for="Amount">Transfer form <%=request.getAttribute("account_number").toString()%></label>
            <input type="text" id="cardNumber" class="input-box" placeholder="Enter amount" required>
            <button class="confirm-button">Confirm Payment</button>
        </form>
        </div>
        <%
            try {
                session = request.getSession();
                String username = session.getAttribute("NetbankingId").toString();
                Account_holder_operation aho = new Account_holder_operation();
                account_holder ah = aho.getaccountholder(username);
                request.setAttribute("account_number", ah.getAccount_no());

            } catch (Exception e) {
                out.println(e);
            }
        %>
    </body>
</html>

