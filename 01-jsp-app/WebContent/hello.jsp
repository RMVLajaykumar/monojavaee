<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>hello world</h1>
Today date is <%= new java.util.Date() %>
<!-- Expression tags -->
<br>
Sum of 10 and 20 is<%= 10+20 %><br>
Is 10 greater than 20<%= 10>20%><br>
String in Caps <%=new String("Hello world").toUpperCase() %>

<!-- Scriptlet tag -->
  <%
  for(int i=0;i<10;i++){
	  out.println("<h4>number"+i+"</h4>");
  }
  %>
  
  <!-- Declaration tag -->
  <%!String covertTOUperCase(String str){
	  return str.toUpperCase();
  }%>
  
  <%=covertTOUperCase("India is my country") %>
  
  <%! 
String FirstLetterOfWordToCap(String str) {
    String[] words = str.split(" ");
    StringBuilder capitalized = new StringBuilder();

    for (String word : words) {
        if (word.length() > 0) {
            capitalized.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
        }
    }
    return capitalized.toString().trim();
}
%><br>
  
  
  <%= FirstLetterOfWordToCap("india is my country") %>
</body>
</html>