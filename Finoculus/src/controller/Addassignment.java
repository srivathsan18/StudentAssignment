package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Addpojo;
import totalcode.Totalcode;


@WebServlet("/Addassignment")
public class Addassignment extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String assignname=request.getParameter("assignname");
		String assigndate=request.getParameter("assigndate");
		String status=request.getParameter("status");
		HttpSession session=request.getSession();
		String id="";
		try{
		id=(String)session.getAttribute("ses");
		if(id.equals("")){
			response.sendRedirect("Login.jsp");

			
		}
		}
		catch(Exception e){
			response.sendRedirect("Login.jsp");
		}

		
		Addpojo a=new Addpojo();
		a.setAssignname(assignname);
		a.setAssigndate(assigndate);
		a.setStatus(status);
		a.setId(id);
		Totalcode t=new Totalcode();
		int i=t.add(a);
		if(i>0) {
			response.sendRedirect("view.jsp");
			
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
