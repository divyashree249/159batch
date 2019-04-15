<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!int i=0; %>	
<% i++;
	response.setIntHeader("refresh",5);%>
<%= i %>

<% String name=request.getParameter("name");
out.print("Welcome  "+name);

pageContext.setAttribute("auser",name,PageContext.APPLICATION_SCOPE);

pageContext.setAttribute("suser",name,PageContext.SESSION_SCOPE);

pageContext.setAttribute("puser",name,PageContext.PAGE_SCOPE);

pageContext.setAttribute("ruser",name,PageContext.REQUEST_SCOPE);

%>

<%-- <%
out.print("data is");
String name1=(String)pageContext.getAttribute("user",PageContext.PAGE_SCOPE);
out.print("value is "+name1);
%> --%>
<a href="second.jsp">Click here</a>

</body>
</html>