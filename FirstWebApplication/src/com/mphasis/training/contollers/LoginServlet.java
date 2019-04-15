package com.mphasis.training.contollers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.training.dao.FuserDao;
import com.mphasis.training.daoimpl.FuserDaoImpl;

@WebServlet("/signin")
public class LoginServlet extends HttpServlet {
	
	FuserDao fuserDao=new FuserDaoImpl();
	
	public void service(HttpServletRequest request,
	HttpServletResponse response)throws ServletException,IOException {
			//response.setContentType("application/msword");
		response.setContentType("text/html");
			String name=request.getParameter("lname");
			String pass=request.getParameter("pwd");
			PrintWriter pw=response.getWriter();
			boolean valid=fuserDao.login(name, pass);
			if(valid) {
				pw.print("welcome "+name);
				/*pw.print("<form action='Profile'>");
				pw.print("<input type='hidden' name='email' value="+name+">");
				pw.print("<input type='submit' value='profile'>");
				pw.print("</form>");*/
				HttpSession session=request.getSession();
				session.setAttribute("sname", name);
				
				RequestDispatcher rd=request.getRequestDispatcher("menu.html");
				rd.include(request, response);
			}
			else {
				pw.print("invalid credentials");
		RequestDispatcher rd=request.getRequestDispatcher("login.html");
				rd.include(request, response);
				//response.sendRedirect("http://www.google.com");
				/*RequestDispatcher rd=request.getRequestDispatcher("http://www.google.com");
				rd.forward(request, response);*/
				
			}
	}
}
