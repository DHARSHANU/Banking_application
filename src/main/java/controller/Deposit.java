package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import dao.Bankdao;
import dto.BankTransaction;
import dto.Bankaccount;
import dto.Customer;

@WebServlet("/deposit")
public class Deposit extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	Customer customer =	(Customer) req.getSession().getAttribute("customer");
		
		if(customer==null)
		{
		resp.getWriter().print("<h1>Session Expired Login Again</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
		}
		else{
		
		double amount	=Double.parseDouble(req.getParameter("amont"));
	
long acno =	(Long) req.getSession().getAttribute("acno");
Bankdao  bankdao = new Bankdao();
 Bankaccount bankaccount = bankdao.find(acno);
 bankaccount.setAmount( bankaccount.getAmount()+amount);
 
 BankTransaction bankTransaction = new BankTransaction();
 bankTransaction.setDeposite(amount);
bankTransaction.setWitdraw(0);
bankTransaction.setBalance(bankaccount.getAmount());
bankTransaction.setDateTime(LocalDateTime.now());


 List< BankTransaction>list= bankaccount.getBankTransactions();
 list.add(bankTransaction);
 bankaccount.setBankTransactions(list);
 
 bankdao.update(bankaccount);
 
 resp.getWriter().print("<h1>Amount added Successfully</h1>");
 req.getRequestDispatcher("Accounthome.jsp").include(req, resp);
	}
}
}