package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Bankdao;
import dao.Customerdao;
import dto.Bankaccount;
import dto.Customer;

@WebServlet("/createbankaccount")
public class Createbankaccount extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String banktype= req.getParameter("banktype");	
	
	Customer customer 	=(Customer) req.getSession().getAttribute("customer");
	
	
	List< Bankaccount>list = customer.getBankaccount();
	
	boolean flag=true;
	
	for(Bankaccount bankaccount :list)
	{
		if(bankaccount.getType().equals(banktype)){
			
			flag=false;
			break;
		}}
	if(flag){
			
			
	Bankaccount bankaccount = new Bankaccount();
	bankaccount.setType(banktype);
	if(banktype.equals("saving")){
		bankaccount.setAcclimit(10000);
	}else{
		bankaccount.setAcclimit(50000);
	}
	bankaccount.setCustomer(customer);
	Bankdao bankdao = new Bankdao();
	bankdao.save(bankaccount);
	
	
	list.add(bankaccount);
	
	customer.setBankaccount(list);
	
	
	Customerdao customerdao = new  Customerdao();
	customerdao.update(customer);
	
	resp.getWriter().print("<h1>Account created successfully wait for management to approve</h1>");
	req.getRequestDispatcher("login.html").include(req, resp);
	}
	else{
		
		resp.getWriter().print("<h1>"+banktype+"Account alerady exists</h1>");
        req.getRequestDispatcher("customerhome.html").include(req, resp);		
	
	
	}
	}
	
	}

