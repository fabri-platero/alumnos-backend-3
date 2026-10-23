<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html><head><meta charset="utf-8"><title>Docentes</title></head>
<body>
  <h2>Docentes que dictan más de dos materias</h2>
  <table border="1" cellpadding="6">
    <tr><th>Nombre</th><th>Cargo</th></tr>
    <c:forEach var="d" items="${lista}">
      <tr><td>${d.nombre}</td><td>${d.cargo}</td></tr>
    </c:forEach>
  </table>
  <p><a href="index.jsp">Volver</a></p>
</body></html>