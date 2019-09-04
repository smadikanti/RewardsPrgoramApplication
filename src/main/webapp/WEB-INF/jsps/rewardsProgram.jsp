<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rewards program:</title>
</head>
<body>
<h2><font color="#800000">Rewards Calculation</font></h2>
<form action="calculateRewards" method="post">
Enter Customer ID: <input type="text" name="customerId"/>
Enter Transaction Amount: <input type="text" name="transactionAmount"/>
Enter Transaction Date: <input type="text" name="transactionDate"/>
<br/><br/>
<input type="submit" size=15 value="Save"/>
</form>
</body>
</html>