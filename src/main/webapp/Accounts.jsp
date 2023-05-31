<%@page import="dto.Bankaccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Account</title>
</head>
<body>
<% List<Bankaccount> list=(List<Bankaccount>)request.getAttribute("list"); 
if(list.isEmpty())
{
%>
<h1>No Active Accounts Found</h1>
<%}else{ %>
<h1>Select Bank Account</h1>
<%for(Bankaccount  bankaccount:list){ %>
<a href="setaccount?accno=<%= bankaccount.getAccountno()%>"><button><%=bankaccount.getAccountno() %></button></a><br><br>

<%} %>
<%} %>
<br>
<a href="customerhome.html"><button>back</button></a>
</body>
</html>