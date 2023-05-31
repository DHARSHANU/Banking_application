package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Bankaccount;
import dto.Customer;

@WebServlet("/fetchactiveaccount")
public class Fetchactiveaccount extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Customer customer =	(Customer) req.getSession().getAttribute("customer");
	if(customer==null)
	{
	resp.getWriter().print("<h1>Session Expired Login Again</h1>");
	req.getRequestDispatcher("login.html").include(req, resp);
	}
	else{
	
	List<Bankaccount> list = customer.getBankaccount();
	
	List<Bankaccount>list2 = new ArrayList<Bankaccount>();
	for(Bankaccount bankaccount :list){
		if(bankaccount.isStatus()){
			list2.add(bankaccount);
		}
	}
	req.setAttribute("list",list2 );
	req.getRequestDispatcher("Accounts.jsp").include(req, resp);
	}
	}
}
