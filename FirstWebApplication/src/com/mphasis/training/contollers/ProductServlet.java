package com.mphasis.training.contollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.training.dao.ProductDao;
import com.mphasis.training.daoimpl.ProductDaoImpl;
import com.mphasis.training.pojos.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProductDao productDao=new ProductDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
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
		
		List<Product> products=productDao.getAllProduct();
		PrintWriter out=response.getWriter();
		
		
		try {
			HttpSession session=request.getSession(false);
			String email=(String)session.getAttribute("sname");
		out.print("welcome product "+email);
		RequestDispatcher rd=request.getRequestDispatcher("menu.html");
		rd.include(request, response);
		out.print("<table><tr><th>Pid</th><th>Pname</th>"
				+ "<th>cost</th><th>quantity</th><th>action</th></tr>");
		for(Product product:products) {
			int pid=product.getPid();
			out.print("<tr><td"+pid
					+ "</td><td>"+product.getPname()
					+ "</td><td>"+product.getCost()
					+ "</td><td>"+product.getQuantity()
					+ "</td><td><a href='delete?pid="+pid+"'>delete</a></td>"
					+ "</tr>");
		}
		out.print("</table>");
		}
		catch(NullPointerException e){
			out.print("please login again");
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
