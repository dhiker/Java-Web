<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
	<script>
//	    var url = document.location.href;	
//	    var start = url.indexOf("=")+1;		
	    var value = '${id}';
	    
	    if (value!= "") {						
		    //value= url.substring(start);
		    document.write('<h1>Welcome '+ value+ '</h1>');
	    }
	</script>
</head>

<body>
</body>
</html>