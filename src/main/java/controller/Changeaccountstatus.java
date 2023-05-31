package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Bankdao;
import dto.Bankaccount;

@WebServlet("/changestatus")
public class Changeaccountstatus extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
long accno = Long.parseLong(req.getParameter("accno"));

Bankdao  bankdao = new Bankdao();
Bankaccount bankaccount  = bankdao.find(accno);

if(bankaccount.isStatus()){
	bankaccount.setStatus(false);
}else{
	bankaccount.setStatus(true);
}

bankdao.update(bankaccount);
resp.getWriter().print("<h1> update success</h1>");
req.setAttribute("list", bankdao.fetchall());
req.getRequestDispatcher("adminhome.jsp").include(req, resp);
	}}
