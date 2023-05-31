package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Bankaccount;

@WebServlet("/setaccount")
public class Setaccount extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	long accno = Long.parseLong(req.getParameter("accno"));
	

	
	req.getSession().setAttribute("acno", accno);
	
	req.getRequestDispatcher("Accounthome.jsp").include(req, resp);
	}
}
