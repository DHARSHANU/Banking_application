<%@page import="dto.BankTransaction"%>
<%@page import="dto.Customer"%>
<%@page import="dto.Bankaccount"%>
<%@page import="dao.Bankdao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%Customer customer=(Customer)session.getAttribute("customer"); 
if(customer==null)
{
response.getWriter().print("<h1>Session Expired Login Again</h1>");
request.getRequestDispatcher("login.html").include(request, response);
}
else{
%>
<%long acno =	(Long) session.getAttribute("acno");

Bankdao  bankdao = new Bankdao();
 Bankaccount bankaccount = bankdao.find(acno);
 
 Customer customer1= bankaccount.getCustomer();
 
 List<BankTransaction> list = bankaccount.getBankTransactions();
 %>
 <h1>Account number :-<%=acno %></h1><br>
 <h1>Account Type :-<%=bankaccount.getType() %></h1><br>
 
 <table border="1">
 <tr>
 <th>Trancation_id</th>
 <th>Deposite</th>
 <th>Withdraw</th>
 <th>Balance</th>
 <th>Time</th>
 
 </tr>
 <%for(BankTransaction  bankTransaction:list){ %>
 
 <tr>
 <th><%=bankTransaction.getId() %></th>
 <th><%=bankTransaction.getDeposite() %></th>
 <th><%=bankTransaction.getWitdraw() %></th>
 <th><%=bankTransaction.getBalance() %></th>
 <th><%=bankTransaction.getDateTime() %></th>
 
 </tr>
 
 <%} %>
 
 </table>
 
 <a href="Accounthome.jsp"><button>back</button></a>
<%} %>
</body>
</html>