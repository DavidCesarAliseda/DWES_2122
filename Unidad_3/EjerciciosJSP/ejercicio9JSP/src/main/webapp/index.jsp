<!-- Escribe una aplicación que genere el calendario de un mes. Se pedirá el  nombre del mes, el año, el texto que queremos que aparezca sobre el
    calendario, el día de la semana en que cae el día 1 y el número de días que  tiene el mes. -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ejercicio 8</title>
</head>
<body>
	
	<form method="post">
		<label for="mes">Mes: </label> 
		<select name="mes">
        	<option value="1">enero</option>
        	<option value="2">febrero</option>
        	<option value="3">marzo</option>
        	<option value="4">abril</option>
        	<option value="5">mayo</option>
        	<option value="6">junio</option>
        	<option value="7">julio</option>
        	<option value="8">agosto</option>
        	<option value="9">septiembre</option>
        	<option value="10">octubre</option>
        	<option value="11">noviembre</option>
        	<option value="12">diciembre</option>
      	</select> 
		</br></br>
		<label for="anio">Año: </label> 
		<input id="anio" type="number" name="anio" /><br>
		
		<br> <input type="submit" value="Enviar" />
    
	</form>
	<% 
	if (request.getMethod().equals("POST")) {
		int mes = Integer.parseInt(request.getParameter("mes"));
	    int anio = Integer.parseInt(request.getParameter("anio"));
	    String[] nombreMes = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
	    
	    Calendar miCalendario = Calendar.getInstance();
	    miCalendario.set(anio, mes - 1, 1); // los meses van de 0 a 11
	    
	    int diasTotales = miCalendario.getActualMaximum(Calendar.DAY_OF_MONTH);
	    
	    int dia1 = miCalendario.get(Calendar.DAY_OF_WEEK);
	    if (dia1 == 1) {
	        dia1 = 7; // el domingo es día 1
	    } else {
	        dia1--;
	    }
	    
	    int columna = 1;
	    %>
	    <h1><% out.print(nombreMes[mes - 1] + " " + anio);%></h1>

    	<table>
      		<tr><th>lunes</th><th>martes</th><th>miércoles</th><th>jueves</th><th>viernes</th><th>sábado</th><th>domingo</th></tr>
      		<tr>
      <%
      for (int i = 1; i < diasTotales + dia1; i++) {
          if (i >= dia1) {
            out.print("<td>" + (i - dia1 + 1) + "</td>");
          } else {
            out.print("<td> </td>"); // pinta los huecos que corresponden a los días del mes pasado
          }
          columna++;
          if (columna == 8) { // termina la fila actual
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