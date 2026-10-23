<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><meta charset="utf-8"><title>Carreras de la facultad</title></head>
<body>
  <h2>Carreras de ${facultad.nombre}</h2>
  <table border="1" cellpadding="6">
    <tr><th>ID</th><th>Nombre</th></tr>
    <c:forEach var="c" items="${facultad.carreraCollection}">
      <tr><td>${c.idcarrera}</td><td>${c.nombre}</td></tr>
    </c:forEach>
  </table>
  <p><a href="index.jsp">Volver</a></p>
</body>
</html>