<%@page import="org.apache.tomcat.dbcp.dbcp2.SQLExceptionList"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="Customers.account_holder"%>
<%@page import="Operation.Account_holder_operation" %>
<%@page import="Customers.Client" %>
<%@page import="Operation.connection"%>
<%@page import=" javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bank Portal</title>
        <style>
            /* Reset some default styles for better consistency */
            
            body, h1, h2, h3, p, ul, li, table {
                margin: 0;
                padding: 0;
            }
    body {
                font-family: Arial, sans-serif;
            }
            header {
                background-color: blue;
                color: #fff;
                padding: 20px;
            }

            header h1 {
                margin: 0;
            }

            nav ul {
                list-style: none;
            }

            nav ul li {
                display: inline;
                margin-right: 20px;
            }

            nav a {
                color: #fff;
                text-decoration: none;
            }

            main {
                padding: 20px;
            }

            .account-summary, .transaction-history {
                margin-bottom: 20px;
                font-size: 30px;
                font-style: Bold
            }

            table {
                width: 100%;
                border-collapse: collapse;
            }

            table th, table td {
                border: 1px solid #ccc;
                padding: 8px;
                text-align: left;
            }

            table th {
                background-color: #f2f2f2;
            }
        </style>
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <header>
          <h1>State bank of India</h1>
            <nav>
                <ul>
                    <li><a href="Portal.jsp">Home</a></li>
                    <li><a href="Check_balance.jsp">Accounts</a></li>
                    <li><a href="Transfer.html">Transfer</a></li>
                    <li><a href="#">Payments</a></li>
                    <li><a href="#">Settings</a></li>
                    <li><a href="Transaction_history.jsp">Transaction History</a></li>
                </ul>
            </nav>
        </header>
        <%
            try {
                session = request.getSession();
                String username = session.getAttribute("NetbankingId").toString();
                Account_holder_operation aho = new Account_holder_operation();
                account_holder ah = aho.getaccountholder(username);
                request.setAttribute("account_number", ah.getAccount_no());
                request.setAttribute("firstname", ah.getFirstname());
                request.setAttribute("Lastename", ah.getLastname());
                request.setAttribute("Accountbalance", ah.getBalance());
            } catch (Exception e) {
                out.print(e);
            }
        %>
    <center>
        <main>
            <section class="account-summary">
                <h2>Welcome:<%=request.getAttribute("firstname").toString()%> <%=request.getAttribute("Lastename").toString()%></h2>
                <h2>Account number: <%=request.getAttribute("account_number").toString()%></h2
                <h1>Availabe balance: <%=request.getAttribute("Accountbalance").toString()%>Rs</h1>
             </section>
        </main>
    <div id="carouselExampleIndicators" class="carousel slide">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
        <img src="https://st.adda247.com/https://wpassets.adda247.com/wp-content/uploads/multisite/sites/5/2022/08/16085413/7-5.jpg" class="d-block w-100" alt="..." height="450px">
    </div>
    <div class="carousel-item">
        <img src="https://image.isu.pub/170124091008-4f6a773df09bfe9f030d196d99268a8d/jpg/page_1.jpg" width="400px" height="450px">
    </div>
    <div class="carousel-item">
        <img src="https://i.pinimg.com/originals/39/0e/0b/390e0bbe378bd8a45a648b6e6d249606.jpg" width="400px" height="450px">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
   </center>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
