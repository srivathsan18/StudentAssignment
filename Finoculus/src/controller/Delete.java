package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import totalcode.Totalcode;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=0;
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
	Totalcode t=new Totalcode();
	i=t.delete(id,aid);
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
