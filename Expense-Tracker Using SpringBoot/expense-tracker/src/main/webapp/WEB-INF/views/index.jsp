<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Expense Tracker</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
            background-color: #f9f9f9;
            color: #333;
        }
        h2 {
            color: #2c3e50;
        }
        form {
            background: #ffffff;
            padding: 20px;
            margin-bottom: 30px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            border-radius: 6px;
            max-width: 400px;
        }
        label {
            display: inline-block;
            margin: 8px 0 4px 0;
            font-weight: bold;
        }
        select, input[type="text"], input[type="number"], input[type="date"] {
            width: 100%;
            padding: 8px 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 14px;
        }
        button {
            background-color: #2980b9;
            color: white;
            padding: 10px 18px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #1c5980;
        }
        hr {
            border: none;
            border-top: 1px solid #ddd;
            margin: 40px 0;
        }
        table {
            width: 100%;
            max-width: 700px;
            border-collapse: collapse;
            background: #fff;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            border-radius: 6px;
            overflow: hidden;
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            font-size: 14px;
        }
        th {
            background-color: #2980b9;
            color: white;
            text-transform: uppercase;
            letter-spacing: 0.05em;
        }
        tr:hover {
            background-color: #f1f7ff;
        }
        .container {
            display: flex;
            flex-wrap: wrap;
            gap: 40px;
        }
        .form-wrapper {
            flex: 1 1 300px;
        }
        .summary-wrapper {
            flex: 2 1 600px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="form-wrapper">
            <h2>Add Transaction</h2>
            <c:if test="${not empty message}">
                <p style="color: green; font-weight: bold;">${message}</p>
            </c:if>

            <form action="/add" method="post">
                <label for="type">Type:</label>
                <select name="type" id="type" required>
                    <option value="Income">Income</option>
                    <option value="Expense">Expense</option>
                </select>

                <label for="category">Category:</label>
                <input type="text" name="category" id="category" required/>

                <label for="amount">Amount:</label>
                <input type="number" name="amount" id="amount" step="0.01" min="0" required/>

                <label for="date">Date:</label>
                <input type="date" name="date" id="date" required/>

                <button type="submit">Add</button>
            </form>
            <div class="form-wrapper" style="margin-top: 40px;">
                <h2>Upload Transactions CSV</h2>
                <form action="/upload-csv" method="post" enctype="multipart/form-data">
                    <input type="file" name="file" accept=".csv" required />
                    <button type="submit">Upload CSV</button>
                </form>
            </div>
        </div>




        <div class="summary-wrapper">
            <h2>Monthly Summary</h2>
            <form method="get" action="/" style="margin-bottom: 20px;">
                <label for="year">Year:</label>
                <input type="number" name="year" id="year" required style="width: 100px; display: inline-block; margin-right: 10px;"/>

                <label for="month">Month (1-12):</label>
                <input type="number" name="month" id="month" min="1" max="12" required style="width: 100px; display: inline-block; margin-right: 10px;"/>

                <button type="submit">View Summary</button>
            </form>

            <c:if test="${not empty summary}">
                <h3>Results</h3>
                <table>
                    <tr>
                        <th>Type</th>
                        <th>Category</th>
                        <th>Amount</th>
                        <th>Date</th>
                    </tr>
                    <c:forEach var="t" items="${summary}">
                        <tr>
                            <td><c:out value="${t.type}"/></td>
                            <td><c:out value="${t.category}"/></td>
                            <td><c:out value="${t.amount}"/></td>
                            <td><c:out value="${t.date}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </div>
</body>
</html>
