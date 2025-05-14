package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "N3xu!2024_DB#";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }

    public static void main(String[] args) {
        try (Connection conexion = obtenerConexion()) {
            if (conexion != null) {
                System.out.println("Conexión establecida correctamente.");
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}