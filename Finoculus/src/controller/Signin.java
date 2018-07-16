package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Signinpojo;
import totalcode.Totalcode;


@WebServlet("/Signin")
public class Signin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    String email=request.getParameter("email");	
	String pass=request.getParameter("pass");
	Totalcode t=new Totalcode();
	Signinpojo si=new Signinpojo();
	si.setEmail(email);
	String id=t.signin(si);
	
	if(!id.equals("")) {
		HttpSession s=request.getSession();
		s.setAttribute("ses",id);
		response.sendRedirect("view.jsp");
	}
	else {
		response.sendRedirect("signin.jsp");
	}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
