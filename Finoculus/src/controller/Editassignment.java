package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Viewpojo;
import totalcode.Totalcode;

/**
 * Servlet implementation class Editassignment
 */
@WebServlet("/Editassignment")
public class Editassignment extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		String ai=request.getParameter("aid");
		int aid=Integer.parseInt(ai);
		Viewpojo v=new Viewpojo();
		v.setAssignname(assignname);
		v.setAssigndate(assigndate);
		v.setStatus(status);
		v.setAid(aid);
		
		Totalcode t=new Totalcode();
		int i=t.update(v,id);
		if(i>0) {
			response.sendRedirect("view.jsp");
		}
		else {
			
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
