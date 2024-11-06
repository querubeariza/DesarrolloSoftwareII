package paq;
import java.sql.*;

public class Conexion {
    private String nombreBd; // Variable para almacenar el nombre de la base de datos

    private Connection cnn; // Objeto Connection para manejar la conexión a la base de datos

    // Constructor de la clase Conexion que recibe el nombre de la base de datos
    public Conexion(String nombreBd) {
        this.nombreBd=nombreBd; // Asignación del nombre de la base de datos recibido al atributo nombreBd
    }

    // Método público para establecer la conexión a la base de datos
    public Connection establecerConexion() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Cargar el driver JDBC para SQL Server
            cnn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=" + nombreBd + ";trustServerCertificate=true;integratedSecurity=true;"); // Establecer la conexión usando los parámetros necesarios
            return cnn; // Devolver el objeto Connection una vez establecida la conexión

        }
        catch (ClassNotFoundException e){ // Capturar excepción si no se encuentra la clase del driver JDBC
            throw new Exception ("\nError...No se pudo cargar el driver | " + e.getMessage());
        }
        catch (SQLException e){ // Capturar excepción si no se puede establecer la conexión a la base de datos
            throw new Exception ("\nError... No se pudo establecer la conexion a la base de datos | " + e.getMessage());
        }

    }


}


