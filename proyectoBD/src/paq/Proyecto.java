package paq;
import java.sql.*;
import java.util.LinkedList;
import java.io.*;

public class Proyecto {
    private int codigo;
    private String nombre;
    private int horasDedicacion;
    private Date fechaInicio, fechaTerminacion;
    private String descripcion;

    // Constructor
    public Proyecto(int codigo, String nombre, int horasDedicacion, Date fechaInicio, Date fechaTerminacion, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horasDedicacion = horasDedicacion;
        this.fechaInicio = fechaInicio;
        this.fechaTerminacion = fechaTerminacion;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasDedicacion() {
        return horasDedicacion;
    }

    public void setHorasDedicacion(int horasDedicacion) {
        this.horasDedicacion = horasDedicacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", horasDedicacion=" + horasDedicacion +
                ", fechaInicio=" + fechaInicio +
                ", fechaTerminacion=" + fechaTerminacion +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    // Métodos para gestión de proyectos
    public static LinkedList<Proyecto> obtenerProyectosPorInvestigador(int codigoInvestigador) throws SQLException {
        LinkedList<Proyecto> proyectos = new LinkedList<>();
        String query = "{call obtenerProyectosPorInvestigador(?)}"; // Procedimiento almacenado

        try (Connection conn = DriverManager.getConnection(Main.DB_URL, Main.USER, Main.PASS);
             CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setInt(1, codigoInvestigador);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Proyecto proyecto = new Proyecto(rs.getInt("codigo"), rs.getString("nombre"), rs.getInt("horas_dedicacion"),
                        rs.getDate("fecha_inicio"), rs.getDate("fecha_terminacion"), rs.getString("descripcion"));
                proyectos.add(proyecto);
            }
        }

        return proyectos;
    }


    public static LinkedList<Proyecto> horasTotales() throws SQLException {
        LinkedList<Proyecto> proyectos = new LinkedList<>();
        String query = "SELECT * FROM Proyecto WHERE fecha_terminacion = CURDATE()";

        try (Connection conn = DriverManager.getConnection(Main.DB_URL, Main.USER, Main.PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Proyecto proyecto = new Proyecto(rs.getInt("codigo"), rs.getString("nombre"), rs.getInt("horas_dedicacion"),
                        rs.getDate("fecha_inicio"), rs.getDate("fecha_terminacion"), rs.getString("descripcion"));
                proyectos.add(proyecto);
            }
        }

        return proyectos;
    }
   // opcion 4
   private static void eliminarProyectosCulminadosHoy() {
       try (Connection conn = DriverManager.getConnection("jdbc:tu_bd_url", "usuario", "password")) {
           String query = "SELECT * FROM Proyectos WHERE fecha_culminacion = CURDATE()";
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(query);

           System.out.println("Proyectos culminados hoy:");
           FileWriter csvWriter = new FileWriter("proyectos_culminados.csv");
           csvWriter.append("ID,Nombre,Fecha_Culminacion\n");

           while (rs.next()) {
               int id = rs.getInt("id");
               String nombre = rs.getString("nombre");
               String fechaCulminacion = rs.getString("fecha_culminacion");

               System.out.println("ID: " + id);
               System.out.println("Nombre: " + nombre);
               System.out.println("Fecha de Culminación: " + fechaCulminacion);
               System.out.println("------------------------------");

               csvWriter.append(id + "," + nombre + "," + fechaCulminacion + "\n");

               // Eliminar el proyecto
               String deleteQuery = "DELETE FROM Proyectos WHERE id = ?";
               PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);
               deleteStmt.setInt(1, id);
               deleteStmt.executeUpdate();
           }

           csvWriter.flush();
           csvWriter.close();
           System.out.println("Los proyectos culminados han sido respaldados en 'proyectos_culminados.csv' y eliminados de la base de datos.");
       } catch (SQLException | IOException e) {
           e.printStackTrace();
       }
   }

}

