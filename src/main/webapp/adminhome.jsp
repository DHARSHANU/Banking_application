<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="dao.Bankdao"%>
<%@page import="dto.Bankaccount"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th> Account Number</th>
<th> Account Type</th>
<th> Account Name</th>
<th> Customer Id</th>
<th> Status</th>
<th>  Change Status</th>
</tr>
<%  List<Bankaccount> list  = (List<Bankaccount>) request.getAttribute("list"); %>
<% for(Bankaccount bankaccount:list){ %>
<tr>
<th> <%= bankaccount.getAccountno() %></th>
<th> <%= bankaccount.getType() %></th>
<th> <%=  bankaccount.getCustomer().getName() %></th>
<th> <%= bankaccount.getCustomer().getCus_id() %></th>
<th> <%= bankaccount.isStatus() %></th>
<th> <a href="changestatus?accno=<%= bankaccount.getAccountno()%>"><button type="button">Change</button></a></th>
</tr>
<%} %>
</table>

<br>
<a href="Home.html"><button>logout</button></a>

</body>
</html>