<%@page import="com.mphasis.training.pojos.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.mphasis.training.dao.ProductDao"%>
<%@page import="com.mphasis.training.daoimpl.ProductDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#products {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#products td, #products th {
  border: 1px solid #ddd;
  padding: 8px;
}

#products tr:nth-child(even){background-color: #f2f2f2;}

#products tr:hover {background-color: #ddd;}

#products th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
p{
align: center;}
</style>
</head>
<body>
<%@include file="menu.html" %>
<p>
<% String name=(String)session.getAttribute("sname"); 
		out.print(name);%></p>
<h2>List of Products</h2>
<table id="products">
	<tr>
		<th>PID</th>
		<th>Pname</th>
		<th>cost</th>
		<th>Quantity</th>
	</tr>
	<% 
	ProductDao pdao=new ProductDaoImpl();
	List<Product> products=pdao.getAllProduct();
	for(Product pr:products){
		%>
		<tr>
		<td><%=pr.getPid()%></td>
		<td><%=pr.getPname()%></td>
		<td><%=pr.getCost()%></td>
		<td><%=pr.getQuantity()%></td>
		</tr>
	<% } %>
</table>
</body>
</html>