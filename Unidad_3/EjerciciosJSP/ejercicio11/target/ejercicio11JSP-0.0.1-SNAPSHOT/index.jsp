<!-- Realiza una aplicación que genere 100 números aleatorios del 1 al 200. Los
    primos deberán aparecer en un color diferente al resto. -->
    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Esta aplicación genera 100 números aleatorios del 1 al 200. Los primos aparecen en color azul.</p>
	<p>
      <%
        int n;
        for (int i = 0; i < 100; i++) {
          n = (int)(Math.random() * 200) + 1;
          if (esPrimo(n)) {
            out.print("<span style=\"color: blue; font-weight: bold\">" + n + "</span> ");
          } else {
            out.print(n + " ");
          }
        }
      %>
    </p>

</body>
</html>

<%!
  static boolean esPrimo(int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
%>