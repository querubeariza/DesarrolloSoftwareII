/*package paq;

import paq.*;
import java.sql.*;
import java.util.LinkedList;

public class Investigadores {
    private int codigo;
    private String nombre;
    private String areaInvestigacion;

    // Constructor
    public Investigadores(int codigo, String nombre, String areaInvestigacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.areaInvestigacion = areaInvestigacion;
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

    public String getAreaInvestigacion() {
        return areaInvestigacion;
    }

    public void setAreaInvestigacion(String areaInvestigacion) {
        this.areaInvestigacion = areaInvestigacion;
    }

    @Override
    public String toString() {
        return "Investigador{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", areaInvestigacion='" + areaInvestigacion + '\'' +
                '}';
    }

    // Métodos para gestión de investigadores
    public static LinkedList<Investigadores> obtenerInvestigadoresPorProyecto(int codigoProyecto) throws SQLException {
        LinkedList<Investigadores> investigadores = new LinkedList<>();
        String query = "SELECT i.codigo, i.nombre, i.area_investigacion " +
                "FROM Investigador i " +
                "JOIN InvestigadorProyecto ip ON i.codigo = ip.codigo_investigador " +
                "WHERE ip.codigo_proyecto = ?";

        try (Connection conn = DriverManager.getConnection(Main.DB_URL, Main.USER, Main.PASS);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, codigoProyecto);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Investigadores investigador = new Investigadores(rs.getInt("codigo"), rs.getString("nombre"), rs.getString("area_investigacion"));
                investigadores.add(investigador);
            }
        }

        return investigadores;
    }
//opcion 3
private static void mostrarHorasDedicacion() {
    try (Connection conn = DriverManager.getConnection("jdbc:tu_bd_url", "usuario", "password")) {
        String query = "SELECT nombre_investigador, SUM(horas) AS total_horas FROM Dedicacion GROUP BY nombre_investigador";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("Número total de horas de dedicación de cada investigador:");
        while (rs.next()) {
            System.out.println("Investigador: " + rs.getString("nombre_investigador"));
            System.out.println("Total de horas: " + rs.getInt("total_horas"));
            System.out.println("------------------------------");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// opcion 6
private static void modificarInvestigador(Scanner scanner) {
    try (Connection conn = DriverManager.getConnection("jdbc:tu_bd_url", "usuario", "password")) {
        System.out.print("Ingrese el ID del investigador a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el nuevo nombre del investigador: ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Ingrese la nueva área de investigación: ");
        String nuevaArea = scanner.nextLine();

        String updateQuery = "UPDATE Investigadores SET nombre = ?, area_investigacion = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(updateQuery);
        pstmt.setString(1, nuevoNombre);
        pstmt.setString(2, nuevaArea);
        pstmt.setInt(3, id);
        pstmt.executeUpdate();

        System.out.println("Datos del investigador actualizados exitosamente.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}*/

