<div style="backgroun-color:grey">
<a href="<%=request.getContextPath()%>">Volver</a>
<a href="<%=request.getContextPath()+"/Logout"%>">Salir</a>
<% HttpSession sesion = request.getSession(); %>
<p>Usuario: <%= sesion.getAttribute("usuario") %> Sesion: <%= sesion.getAttribute("hora") %></p>
</div>
