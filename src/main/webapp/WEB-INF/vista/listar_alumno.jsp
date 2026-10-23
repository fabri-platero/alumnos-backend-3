<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><meta charset="utf-8"><title>Alumnos</title></head>
<body>
  <h2>Alumnos</h2>
  <table border="1" cellpadding="6">
    <tr><th>ID</th><th>Nombre</th><th>Registro</th><th>Carrera</th></tr>
    <c:forEach var="a" items="${lista}">
      <tr>
        <td>${a.idalumno}</td>
        <td>${a.nombre}</td>
        <td>${a.registro}</td>
        <td>${a.carreraIdcarrera.nombre}</td>
      </tr>
    </c:forEach>
  </table>
  <p><a href="Agregar">Agregar alumno</a> | <a href="index.jsp">Volver</a></p>
</body>
</html>