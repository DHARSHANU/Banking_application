<%@page import="dto.Customer"%>
<%@page import="dto.Bankaccount"%>
<%@page import="dao.Bankdao"%>
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
 
 %>
 
 
 <h1>
 Hello <% if (bankaccount.getCustomer().getGender().equals("male")) {%>Mr.<%} %><%else{ %> Ms.<%} %><%=customer.getName() %>
 </h1>
 <h1>Your <%= bankaccount.getType() %>  account balance is <%=bankaccount.getAmount() %></h1>
<br><br>
<a href="Accounthome.jsp"><button>Back</button></a>

<%} %>
</body>
</html>