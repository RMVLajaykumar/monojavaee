<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <c:set var="name" value="Ajaykumar"></c:set>
  <h1>Welcome ${name}</h1>
  
  
  <c:if test="${name.length()>=5}">
  
    <h1>Name ${name} name has 5 or more character long</h1>
  </c:if>
  
    <c:choose>
    
     <c:when test="${name.equals('Ajaykumar') }">
        your name is Ajay
      </c:when>
      <c:otherwise>
      I dont know your name
      </c:otherwise>
    </c:choose>

</body>
</html>