<!--  Crea la aplicaci�n "El Trile". Deben aparecer tres cubiletes por pantalla  y el usuario deber� seleccionar uno de ellos. Para dicha selecci�n se
      puede usar un formulario con radio-button, una lista desplegable, hacer  clic en el cubilete o lo que resulte m�s f�cil. Se levantar�n los tres
      cubiletes y se ver� si estaba o no la bolita dentro del que el usuario indic�, as� mismo, se mostrar� un mensaje diciendo "Lo siento, no has
      acertado" o "�Enhorabuena!, has encontrado la bolita". La probabilidad de  encontrar la bolita es de 1/3. -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>El trile</title>
</head>
<body>
	<table>
		<tr>
			<td><a href="trile.jsp?cubilete=0"><img src="img/cubilete_tapando_bolas.png"></a></td>
        	<td><a href="trile.jsp?cubilete=1"><img src="img/cubilete_tapando_bolas.png"></a></td>
        	<td><a href="trile.jsp?cubilete=2"><img src="img/cubilete_tapando_bolas.png"></a></td>
		</tr>
	</table>
	<p>Adivina d�nde est� la bolita.</p>
	
</body>
</html>