<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String name=(String)pageContext.getAttribute("suser",
		PageContext.SESSION_SCOPE);
	out.print("session scope value is "+name+"<br/>");
	
	String name1=(String)pageContext.getAttribute("auser",
			PageContext.APPLICATION_SCOPE);
	out.print("application scope value is "+name1+"<br/>");

	String name2=(String)pageContext.getAttribute("puser",
			PageContext.PAGE_SCOPE);
	out.print("page scope value is "+name2+"<br/>");
	
	String name3=(String)pageContext.getAttribute("ruser",
			PageContext.REQUEST_SCOPE);
	out.print("request scope value is "+name3+"<br/>");
%>


<a href="thrid.jsp">Click</a>



</body>
</html>