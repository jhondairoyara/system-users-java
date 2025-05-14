package dao;

import modelo.Usuario;
import conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";

        try (Connection conn = Conexion.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("Id_Usuario"));
                usuario.setNombres(rs.getString("Nombres"));
                usuario.setApellidos(rs.getString("Apellidos"));
                usuario.setTelefono(rs.getString("Telefono"));
                usuario.setDireccion(rs.getString("Direccion"));
                usuario.setIdCiudad(rs.getInt("Id_Ciudad"));
                usuario.setFechaNacimiento(rs.getDate("Fecha_Nacimiento").toLocalDate()); // Corregido

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    @Override
    public Usuario obtenerUsuario(int idUsuario) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE Id_Usuario = ?";

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("Id_Usuario"));
                    usuario.setNombres(rs.getString("Nombres"));
                    usuario.setApellidos(rs.getString("Apellidos"));
                    usuario.setTelefono(rs.getString("Telefono"));
                    usuario.setDireccion(rs.getString("Direccion"));
                    usuario.setIdCiudad(rs.getInt("Id_Ciudad"));
                    usuario.setFechaNacimiento(rs.getDate("Fecha_Nacimiento").toLocalDate()); // Corregido
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    @Override
    public boolean insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (Nombres, Apellidos, Telefono, Direccion, Id_Ciudad, Fecha_Nacimiento) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNombres());
            pstmt.setString(2, usuario.getApellidos());
            pstmt.setString(3, usuario.getTelefono());
            pstmt.setString(4, usuario.getDireccion());
            pstmt.setInt(5, usuario.getIdCiudad());
            pstmt.setDate(6, java.sql.Date.valueOf(usuario.getFechaNacimiento())); // Corregido

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE Usuario SET Nombres = ?, Apellidos = ?, Telefono = ?, Direccion = ?, Id_Ciudad = ?, Fecha_Nacimiento = ? WHERE Id_Usuario = ?";

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNombres());
            pstmt.setString(2, usuario.getApellidos());
            pstmt.setString(3, usuario.getTelefono());
            pstmt.setString(4, usuario.getDireccion());
            pstmt.setInt(5, usuario.getIdCiudad());
            pstmt.setDate(6, java.sql.Date.valueOf(usuario.getFechaNacimiento())); // Corregido
            pstmt.setInt(7, usuario.getIdUsuario());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean eliminarUsuario(int idUsuario) {
        String sql = "DELETE FROM Usuario WHERE Id_Usuario = ?";

        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
