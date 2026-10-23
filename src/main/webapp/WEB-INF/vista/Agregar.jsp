<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><meta charset="utf-8"><title>Agregar alumno</title></head>
<body>
  <h2>Agregar alumno</h2>
  <form method="post" action="GuardarAlumno">
    <p>Nombre: <input name="nombre" maxlength="45" required></p>
    <p>Registro: <input name="registro" maxlength="6" required></p>
    <p>Carrera:
      <select name="carrera">
        <c:forEach var="c" items="${carreras}">
          <option value="${c.idcarrera}">${c.nombre}</option>
        </c:forEach>
      </select>
    </p>
    <button type="submit">Guardar</button>
    <a href="index.jsp">Cancelar</a>
  </form>
</body>
</html>