<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login Page</title>
	
	<script>
		//Script可另外建JS檔匯入，目前無使用CSS
//	    var url = document.location.href;	//get url String
//	    var start = url.indexOf("=")+1;		//get start position of variable
	    var value = '${msg}';				//get message from servlet
	    
	    if (value != "") {						//alert message if servlet sent it
//		    value= url.substring(start);
		    
		    alert(value);
	    }
	</script>
</head>

<body>
	<form name="logininfo" action="RedirectPage" method="post">
		<table>
			<tr><td>UserName:</td><td><input type=text name="id" size=50 /></td></tr>
			<tr><td>Password:</td><td><input type=password name="pw" size=50 /></td></tr>
			<tr><td><input type=submit value="submit" /></td><td><c:out value="${ model['msg'] }" /></td></tr>
		</table>
	</form>
	
</body>

</html>