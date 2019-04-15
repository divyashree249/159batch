package com.mphasis.training.contollers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.training.dao.FuserDao;
import com.mphasis.training.daoimpl.FuserDaoImpl;
import com.mphasis.training.exception.BuissnessException;
import com.mphasis.training.pojos.Fuser;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/Profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	FuserDao fuserDao=new FuserDaoImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//HTTp 1.1
	response.setHeader("Pragma","no-cache");//HTTP1.0
	response.setHeader("Expires", "0");//proxies
	PrintWriter out=response.getWriter();
	//String email=request.getParameter("email");
	try {
		HttpSession session=request.getSession(false);
		String email=(String)session.getAttribute("sname");
		out.print("welcome profile "+email);
		RequestDispatcher rd=request.getRequestDispatcher("menu.html");
		rd.include(request, response);
		Fuser fuser=fuserDao.profile(email);
		out.print("<table border='1'><tr><td>"+fuser.getEmail()
				+ "</td></tr><tr><td>"+fuser.getPass()
				+ "</td></tr><tr><td>"+fuser.getGender()
				+ "</td></tr><tr><td>"+fuser.getCity()
				+ "</td></tr><tr><td>"+fuser.getDob()
				+ "</td></tr></table>");
	} catch (BuissnessException e) {
		// TODO Auto-generated catch block
		out.print("email is invalid");
	}catch(NullPointerException e) {
		out.print("Please login first");
		RequestDispatcher rd=request.getRequestDispatcher("login.html");
		rd.include(request, response);
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
