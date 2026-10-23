package controlador;

import entidad.Alumno;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import sesiones.AlumnoFacade;
import sesiones.CarreraFacade;
import sesiones.DocenteFacade;
import sesiones.ExamenFacade;
import sesiones.FacultadFacade;

@WebServlet(name = "Manejador", loadOnStartup = 1,
        urlPatterns = {"/Listar", "/Facultad", "/Agregar", "/GuardarAlumno", "/ListarAlumnos",
            "/Julio", "/SinRendir", "/Docentes"})
public class Manejador extends HttpServlet {

    @EJB
    private FacultadFacade facu;
    @EJB
    private CarreraFacade carreraF;
    @EJB
    private AlumnoFacade alumnoF;
    @EJB
    private ExamenFacade examenF;
    @EJB
    private DocenteFacade docenteF;

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("facultades", facu.findAll());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        int anio = LocalDate.now().getYear();
        String url = null;

        switch (path) {
            case "/Listar":
                request.setAttribute("lista", carreraF.findAll());
                url = "/WEB-INF/vista/listar_carrera.jsp";
                break;
            case "/Facultad":
                Integer nroFacultad = Integer.parseInt(request.getParameter("codigoFacu"));
                request.setAttribute("facultad", facu.find(nroFacultad));
                url = "/WEB-INF/vista/ListarCarreras.jsp";
                break;
            case "/Agregar":
                request.setAttribute("carreras", carreraF.findAll());
                url = "/WEB-INF/vista/Agregar.jsp";
                break;
            case "/GuardarAlumno":
                Alumno a = new Alumno();
                a.setNombre(request.getParameter("nombre"));
                a.setRegistro(request.getParameter("registro"));
                a.setCarreraIdcarrera(carreraF.find(Integer.valueOf(request.getParameter("carrera"))));
                alumnoF.create(a);
                response.sendRedirect(request.getContextPath() + "/ListarAlumnos");
                return;
            case "/ListarAlumnos":
                request.setAttribute("lista", alumnoF.findAll());
                url = "/WEB-INF/vista/listar_alumno.jsp";
                break;
            case "/Julio":
                request.setAttribute("anio", anio);
                request.setAttribute("lista", examenF.mesasDeJulio(anio));
                url = "/WEB-INF/vista/mesas_julio.jsp";
                break;
            case "/SinRendir":
                request.setAttribute("anio", anio);
                request.setAttribute("lista", alumnoF.sinRendirEnAnio(anio));
                url = "/WEB-INF/vista/sin_rendir.jsp";
                break;
            case "/Docentes":
                request.setAttribute("lista", docenteF.conMasDeDosMaterias());
                url = "/WEB-INF/vista/docentes_mas_de_dos.jsp";
                break;
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}