<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><meta charset="utf-8"><title>Sistema Alumnos</title></head>
<body>
  <h1>Sistema Alumnos</h1>
  <ul>
    <li><a href="Listar">Carreras</a></li>
    <li><a href="ListarAlumnos">Alumnos</a></li>
    <li><a href="Agregar">Agregar alumno</a></li>
    <li>Facultades
      <ul>
        <c:forEach var="facu" items="${facultades}">
          <li><a href="Facultad?codigoFacu=${facu.idfacultad}">${facu.nombre}</a></li>
        </c:forEach>
      </ul>
    </li>
    <li>Consultas
      <ul>
        <li><a href="Julio">Mesas de julio</a></li>
        <li><a href="SinRendir">Alumnos sin rendir este año</a></li>
        <li><a href="Docentes">Docentes con más de 2 materias</a></li>
      </ul>
    </li>
  </ul>
</body>
</html>