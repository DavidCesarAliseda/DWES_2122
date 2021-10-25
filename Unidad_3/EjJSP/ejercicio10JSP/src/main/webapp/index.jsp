<!-- Escribe un programa que muestre los n primeros t�rminos de la serie de   Fibonacci. 
El primer t�rmino de la serie de Fibonacci es 0, el segundo es 1  y el resto se calcula sumando los dos anteriores, 
por lo que tendr�amos que   los t�rminos son 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144... El n�mero n  se debe introducir por teclado. -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fibonacci</title>
</head>
<body>
	<form method="post">
		<p>Esta aplicaci�n muestra los <b>n</b> primeros n�meros de la serie de
		Fibonacci.</p>
		<p>Por favor, introduzca <b>n</b>: </p> 
		<input type="number" min="1" name="n"> 
		
		<input type="submit" value="Aceptar">
	</form>
	<%
	if (request.getMethod().equals("POST")) {
		long f1 = 0;
        long f2 = 1;
        long aux;
        int n = Integer.parseInt(request.getParameter("n"));
        
        switch (n) {
        case 1:
          out.print("0");
          break;
        case 2:
          out.print("0 1");
          break;
        default:
          out.print("0 1");
          while(n > 2) {
            aux = f1;
            f1 = f2;
            f2 = aux + f2;
            out.print(" " + f2);
            n--;
          }
          
      }	
		
	}
	%>

</body>
</html>