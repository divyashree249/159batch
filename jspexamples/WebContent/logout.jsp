<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

String name1=(String)session.getAttribute("sname");
out.print("logged in as "+name1);

session.removeAttribute("sname");
session.invalidate();
pageContext.setAttribute("user",name1,PageContext.SESSION_SCOPE);



%>

<a href="second.jsp">Clcik here</a>
</body>
</html>