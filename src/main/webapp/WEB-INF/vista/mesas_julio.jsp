<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html><head><meta charset="utf-8"><title>Mesas de julio</title></head>
<body>
  <h2>Mesas de examen de julio ${anio}</h2>
  <table border="1" cellpadding="6">
    <tr><th>Alumno</th><th>Materia</th><th>Fecha</th><th>Nota</th></tr>
    <c:forEach var="e" items="${lista}">
      <tr>
        <td>${e.alumno.nombre}</td>
        <td>${e.materia.nombre}</td>
        <td>${e.examenPK.fecha}</td>
        <td>${e.nota}</td>
      </tr>
    </c:forEach>
  </table>
  <p><a href="index.jsp">Volver</a></p>
</body></html>