package dao;

import modelo.Usuario;
import java.util.List;

public interface IUsuarioDAO {
    List<Usuario> listarUsuarios();
    Usuario obtenerUsuario(int idUsuario);
    boolean insertarUsuario(Usuario usuario);
    boolean actualizarUsuario(Usuario usuario);
    boolean eliminarUsuario(int idUsuario);
}
