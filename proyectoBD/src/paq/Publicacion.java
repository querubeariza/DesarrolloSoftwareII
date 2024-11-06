package paq;
import java.util.Date;
import java.sql.*;
/*public class Publicacion {
    private String titulo;
    private String autor;
    private Date fechaPublicacion;
    private String revista;

    public Publicacion(String titulo, String autor, Date fechaPublicacion, String revista) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.revista = revista;
    }

    //Setters y Getters

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }


    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }

    public String getRevista() {
        return revista;
    }
    public String toString() {
        return "Publicacion{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", revista='" + revista + '\'' +
                '}';
    }

    // opcion 5
    private static void agregarPublicacion(Scanner scanner) {
        try (Connection conn = DriverManager.getConnection("jdbc:tu_bd_url", "usuario", "password")) {
            System.out.print("Ingrese el título de la publicación: ");
            String titulo = scanner.nextLine();

            System.out.print("Ingrese el nombre del autor: ");
            String autor = scanner.nextLine();

            System.out.print("Ingrese la fecha de publicación (YYYY-MM-DD): ");
            String fecha = scanner.nextLine();

            String insertQuery = "INSERT INTO Publicaciones (titulo, autor, fecha_publicacion) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, titulo);
            pstmt.setString(2, autor);
            pstmt.setString(3, fecha);
            pstmt.executeUpdate();

            System.out.println("Publicación agregada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}*/