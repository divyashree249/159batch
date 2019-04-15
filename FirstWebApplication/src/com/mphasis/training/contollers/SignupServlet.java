package com.mphasis.training.contollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.training.dao.FuserDao;
import com.mphasis.training.daoimpl.FuserDaoImpl;
import com.mphasis.training.pojos.Fuser;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/Signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Fuser fuser=new Fuser();
       FuserDao fuserDao=new FuserDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("lname");
		fuser.setEmail(email);
		fuser.setPass(request.getParameter("pwd"));
		fuser.setGender(request.getParameter("gender"));
		fuser.setCity(request.getParameter("city"));
		fuser.setDob(request.getParameter("dob"));
	int i=	fuserDao.register(fuser);
	if(i>0) {
		out.print("Welcome registered Success "+email);
		RequestDispatcher rd=request.getRequestDispatcher("menu.html");
		rd.include(request, response);}
	else {
		out.print("not registered");
		RequestDispatcher rd=request.getRequestDispatcher("signup.html");
		rd.include(request, response);}
		
		
		
		
		
		/*String email=request.getParameter("lname");
		String pass=request.getParameter("pwd");
		String gender=request.getParameter("gender");
		String[] lan=request.getParameterValues("lan");
		String city=request.getParameter("city");
		if(email==null||pass==null) {
			out.print("enter username and password");
		}else {
			out.print("you have registered succefully with the details <br/>");
			out.print("email "+email+"<br/>");
			out.print("gender "+gender+"<br/>");
			for(String lan1:lan) {
				out.print("lan "+lan1+"<br/>");	
			}
			out.println("city "+city+"<br/>");
		//}
		*/
	/*Enumeration data=request.getParameterNames();
	while(data.hasMoreElements()) {
		String name= (String) data.nextElement();
		String[] values=request.getParameterValues(name);
		if(values.length==1)
		out.println(name+"  "+values[0]+"<br/>");
		else if(values.length>1) {
			for(String lan:values) {
				out.println(lan+"<br/>");
			}
		}
	}*/
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
