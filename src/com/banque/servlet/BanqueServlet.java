package com.banque.servlet;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejb.entity.Account;
import com.ejb.entity.session.IBanqueLocal;


@WebServlet(urlPatterns = {"*.do"},name = "BS")
public class BanqueServlet extends HttpServlet{
	@EJB
	private IBanqueLocal metier;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doGet(req, resp);
	req.setAttribute("accounts", metier.findAll());
	req.getRequestDispatcher("Banque.jsp").forward(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String action=req.getParameter("action");
	if (action.equals("Credit")){
		String code=req.getParameter("code1");
		double amount= Double.parseDouble(req.getParameter("amount"));
		metier.credit(code, amount);
		
	}else if (action.equals("Debit")){
		String code=req.getParameter("code1");
		double amount= Double.parseDouble(req.getParameter("amount"));
		metier.debit(code, amount);
		
	}else if (action.equals("Transfert")){
		String code1=req.getParameter("code1");
		String code2=req.getParameter("code2");
		double amount= Double.parseDouble(req.getParameter("amount"));
		metier.transfert(code1, amount, code2);
	}else{
		String code=req.getParameter("code1");
		Account a=new Account();
		double amount= Double.parseDouble(req.getParameter("amount"));
		a.setActive(true);
		a.setCode(code);
		a.setSolde(amount);
		metier.add(a);
	}
	req.setAttribute("accounts", metier.findAll());
	req.getRequestDispatcher("Banque.jsp").forward(req, resp);
		//super.doPost(req, resp);
	}
}
