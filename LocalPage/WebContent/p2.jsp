<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="javax.servlet.RequestDispatcher"
    import="dao.DaoTest,vo.Account"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Check Page</title>
</head>

<body>
<%
	String id= request.getParameter("id");
	String pw= request.getParameter("pw");
	String url;
	DaoTest dao= new DaoTest();
	Account a= new Account();
	
	out.clear();
	out = pageContext.pushBody();
	
	if(id.isEmpty() || pw.isEmpty()){
		url="index.html?msg=username/password cant be empty";
	}else {
		a= dao.getQuery(id);
		if(!a.getId().equals("")) {
			if(a.getPw().equals(pw)) {
				url="mpg.html?id="+ a.getId();
			}else{
				url="index.html?msg=username/password incorrect";
			}
		}else{
			url="index.html?msg=username/password incorrect";
		}
	}
	response.sendRedirect(url);
%>

</body>
</html>