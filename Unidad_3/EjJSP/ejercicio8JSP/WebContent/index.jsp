<!-- Escribe una aplicación que genere el calendario de un mes. Se pedirá el  nombre del mes, el año, el texto que queremos que aparezca sobre el
    calendario, el día de la semana en que cae el día 1 y el número de días que  tiene el mes. -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ejercicio 8</title>
</head>
<body>
	
	<form method="post">
		<label for="mes">Mes: </label> 
		<input id="mes" type="text" name="mes" />
		</br></br>
		<label for="anio">Año: </label> 
		<input id="anio" type="number" name="anio" />
		</br></br>
		<label for="descripcion">Texto: </label> 
		<input id="descripcion" type="text" name="descripcion" />
		</br></br>
		El día 1 cae en
      	<select name="dia1">
        	<option value="1">lunes</option>
        	<option value="2">martes</option>
        	<option value="3">miércoles</option>
        	<option value="4">jueves</option>
        	<option value="5">viernes</option>
        	<option value="6">sábado</option>
        	<option value="7">domingo</option>
      	</select>
		</br></br>
		<label for="diastotales">Numero de dias que tiene el mes </label>  
		<input type="number" min="28" max="31" name="diastotales"></br>
		</br>
		<br> <input type="submit" value="Enviar" />
    
	</form>
	<% 
	if (request.getMethod().equals("POST")) {
		%>
		<h1><% out.print(request.getParameter("mes") + " " + request.getParameter("anio"));%></h1>
  		<h3><%out.print(request.getParameter("descripcion"));%></h3>
    	<table>
      		<tr><th>lunes</th><th>martes</th><th>miércoles</th><th>jueves</th><th>viernes</th><th>sábado</th><th>domingo</th></tr>
      		<tr>
      		<%
      int columna = 1;
      int diasTotales = Integer.parseInt(request.getParameter("diastotales"));
      int dia1 = Integer.parseInt(request.getParameter("dia1"));
      
      for (int i = 1; i < diasTotales + dia1; i++) {
        if (i >= dia1) {
          out.print("<td>" + (i - dia1 + 1) + "</td>");
        } else {
          out.print("<td> </td>"); // las primeras celdas quedan vacías
        }
        columna++;
        if (columna == 8) { // salta a la siguiente columna
          out.println("</tr><tr>");
          columna = 1;
        }
      }
      %>
		</td></tr>
    </table>
	<% 
	}
	%>
	
	
</body>
</html>