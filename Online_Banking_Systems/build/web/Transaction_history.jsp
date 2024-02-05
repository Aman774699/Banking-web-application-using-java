<%@page import="Operation.Transaction"%>
<!DOCTYPE html>
<%@page import="Customers.account_holder" %>
<%@page import="Operation.Account_holder_operation"%>
<%@page import="Customers.Client"%>
<%@page import="Operation.connection"%>
<%@page import="Customers.Transactions" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Transaction History</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }
            th, td {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
            th {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>

        <h1>Transaction History</h1>

        <table id="transactionTable">
            <%
                try {
                    session = request.getSession();
                    String username = session.getAttribute("NetbankingId").toString();
                    Account_holder_operation aho = new Account_holder_operation();
                    account_holder ah = aho.getaccountholder(username);
                    long accountnumber = ah.getAccount_no();
                    Transaction tn = new Transaction();
                    Transactions tn1 = new Transactions();
                    tn1 = tn.fetchtransition(accountnumber);
                    request.setAttribute("Transaction_id", tn1.getTransactions_id());
                    request.setAttribute("Transaction_date", tn1.getTransaction_date());
                    request.setAttribute("Account_from", tn1.getAccount_from());
                    request.setAttribute("Account_to", tn1.getAccount_to());
                    request.setAttribute("Amount", tn1.getAmont());
                    request.setAttribute("transaction_type", tn1.getTransaction_type());
                    request.setAttribute("current_balance", tn1.getCurrentbalance());
             
                } catch (Exception e) {
                    out.println(e);
                }
            %>
            <thead>
                <tr>
                    <th>Transaction_id</th>
                    <th>Transaction_date</th>
                    <th>Account_from</th>
                    <th>Account_to</th>
                    <th>Amount</th>
                    <th>Transaction_type</th>
                    <th>Available balance</th>
                </tr>
            </thead>
            <tbody>
            <td> <%=request.getAttribute("Transaction_id")%></td><!-- comment -->
            <td> <%=request.getAttribute("Transaction_date")%></td><!-- comment -->
            <td> <%=request.getAttribute("Account_from")%></td><!-- comment -->
            <td> <%=request.getAttribute("Account_to")%></td><!-- comment -->
            <td> <%=request.getAttribute("Amount")%></td><!-- comment -->
            <td> <%=request.getAttribute("transaction_type")%></td><!-- comment -->
            <td> <%=request.getAttribute("current_balance")%></td><!-- comment -->
            </tbody>

        </table>


    </body>
</html>
