package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Signuppojo;
import totalcode.Totalcode;


@WebServlet("/Signup")
public class Signup extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String rpass=request.getParameter("rpass");
		String sid="";
		int i=0;
		 if(pass.equals(rpass)){
		       
		       Date dNow = new Date( );
		      SimpleDateFormat ft =new SimpleDateFormat ("yyMMddHHmmss");
		     sid=ft.format(dNow)+"";
		     System.out.print(sid);
		 
		 Totalcode t=new Totalcode();
		 Signuppojo su=new Signuppojo();
		 su.setName(name);
		 su.setEmail(email);
		 su.setPass(rpass);
		 su.setSid(sid);
		 
		  i=t.signup(su);
		 }
		
        if(i>0) {
        	response.sendRedirect("signin.jsp");
        	out.println("Successfully signed up");
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
