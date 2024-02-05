<%@page import="Customers.account_holder" %>
<%@page import="Operation.Account_holder_operation"%>
<%@page import="Customers.Client"%>
<%@page import="Operation.connection"%>
<%@page import=" javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Banking Application</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                /*margin: 0;*/
                /*padding: 0;*/
                background-color: #f4f4f4;
                color: #333;
                /*display: flex;*/
                align-items: center;
                justify-content: center;
                height: 100vh;
            }
            header {
                background-color: #2c3e50;
                color: #ecf0f1;
                text-align: center;
                padding: 1em;
            }

            nav {
                background-color: #3498db;
                color: #ecf0f1;
                padding: 0.5em;
                text-align: center;
            }
            nav a {
                color: #ecf0f1;
                text-decoration: none;
                padding: 0.5em 1em;
                margin: 0 1em;
                border-radius: 5px;
                background-color: #2980b9;
            }
            section {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 60vh;
            }

            iframe {
                border: none;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
                border-radius: 5px;
            }
            footer {
                background-color: #34495e;
                color: #ecf0f1;
                text-align: center;
                padding: 1em;
                position: fixed;
                bottom: 0;
                width: 100%;
            }
            transfer-box {
                background-color: #fff;
                border: 1px solid #ddd;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                width: 300px;
            }
            /*          body {
                        font-family: 'Arial', sans-serif;
                        background-color: #f4f4f4;
                        margin: 0;
                        display: flex;
                        align-items: center;
                        justify-content: center;
                        height: 100vh;
                    }*/

            main {
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding: 20px;
                border-radius: 8px;
            }

            #transfer-box {
                text-align: center;
            }

            label {
                display: block;
                margin-bottom: 8px;
                font-weight: bold;
                color: #333;
            }

            input {
                width: 100%;
                padding: 10px;
                margin-bottom: 16px;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 4px;
                font-size: 16px;
            }

            button {
                background-color: #4caf50;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 18px;
                transition: background-color 0.3s ease;
            }

            button:hover {
                background-color: #45a049;
            }
        </style>
        <script>
            function validate()
            {
                var a = document.getElementById("amount").value;
                var b = document.getElementById("benificary").value;
                if (a == 0)
                {
                    alert("Amount must be greater than zero");
                }
                if (a == " ")
                {
                    alert("The Amount does not have blank value");
                }
                if (b == " ")
                {
                    alert("Enter the Benificary number");
                }
                if (b.length < 10)
                {
                    alert("Enter the Benificary number Proper");
                }
            }

        </script>
    </head>
    <body>
        <header>
            <h1>State Bank Of India</h1>
        </header>
        <nav>
            <a href="Portal.jsp">Home</a>
            <a href="https://sbi.co.in/web/customer-care/contact-us">Contact</a>
        </nav>
        <%
            try {
                session = request.getSession();
                String username = session.getAttribute("NetbankingId").toString();
                Account_holder_operation aho = new Account_holder_operation();
                account_holder ah = aho.getaccountholder(username);
                request.setAttribute("account_number", ah.getAccount_no());
                request.setAttribute("account_number", ah.getAccount_no());
                request.setAttribute("firstname", ah.getFirstname());
                request.setAttribute("Lastename", ah.getLastname());
                request.setAttribute("Accountbalance", ah.getBalance());
            } catch (Exception e) {
                out.println(e);
            }
        %>
        <main>
            <!--<section class="account-summary">-->
            <h2>Owner name:<%=request.getAttribute("firstname").toString()%> <%=request.getAttribute("Lastename").toString()%></h2>
            <h2>Owner Account number: <%=request.getAttribute("account_number").toString()%></h2>
            <h1>Availabe balance: <%=request.getAttribute("Accountbalance").toString()%>Rs</h1>
            <!--</section>-->
        </main>
        <form method="post" action="Transfer_amount">
            <main>
                <div id="transfer-box">
                    <label for="amount">Amount:</label>
                    <input type="text" name="amount"  placeholder="Enter amount" >
                    <br>
                    <label for="Benificary">Enter the Benificary account number</label>
                    <input type="text" name="benificary" placeholder="Enter the Benificary account number">
                    <br>
                    <!--<button onclick="validate()">Transfer</button>-->
                    <button>     
                        <input type="Submit" value="Transfer" onclick="validate()"></button>
                </div>
            </main>
        </form>
        <footer>
            &copy; 2023 Banking Application. All rights reserved.
        </footer>
    </body>
</html>
