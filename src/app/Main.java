package principal;

import dao.UsuarioDAO;
import modelo.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ CRUD USUARIO ---");
            System.out.println("1. Listar usuarios");
            System.out.println("2. Insertar usuario");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Buscar usuario por ID");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el salto de línea

            switch (opcion) {
                case 1:
                    List<Usuario> usuarios = usuarioDAO.listarUsuarios();
                    if (usuarios.isEmpty()) {
                        System.out.println("No hay usuarios registrados.");
                    } else {
                        for (Usuario u : usuarios) {
                            System.out.println(u);
                        }
                    }
                    break;

                case 2:
                    Usuario nuevoUsuario = new Usuario();
                    System.out.print("Nombres: ");
                    nuevoUsuario.setNombres(scanner.nextLine());

                    System.out.print("Apellidos: ");
                    nuevoUsuario.setApellidos(scanner.nextLine());

                    System.out.print("Teléfono: ");
                    nuevoUsuario.setTelefono(scanner.nextLine());

                    System.out.print("Dirección: ");
                    nuevoUsuario.setDireccion(scanner.nextLine());

                    System.out.print("ID Ciudad: ");
                    nuevoUsuario.setIdCiudad(scanner.nextInt());
                    scanner.nextLine(); // limpiar salto

                    System.out.print("Fecha de nacimiento (AAAA-MM-DD): ");
                    nuevoUsuario.setFechaNacimiento(LocalDate.parse(scanner.nextLine()));

                    if (usuarioDAO.insertarUsuario(nuevoUsuario)) {
                        System.out.println("✅ Usuario insertado correctamente.");
                    } else {
                        System.out.println("❌ Error al insertar usuario.");
                    }
                    break;

                case 3:
                    Usuario actualizar = new Usuario();
                    System.out.print("ID del usuario a actualizar: ");
                    actualizar.setIdUsuario(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Nombres: ");
                    actualizar.setNombres(scanner.nextLine());

                    System.out.print("Apellidos: ");
                    actualizar.setApellidos(scanner.nextLine());

                    System.out.print("Teléfono: ");
                    actualizar.setTelefono(scanner.nextLine());

                    System.out.print("Dirección: ");
                    actualizar.setDireccion(scanner.nextLine());

                    System.out.print("ID Ciudad: ");
                    actualizar.setIdCiudad(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Fecha de nacimiento (AAAA-MM-DD): ");
                    actualizar.setFechaNacimiento(LocalDate.parse(scanner.nextLine()));

                    if (usuarioDAO.actualizarUsuario(actualizar)) {
                        System.out.println("✅ Usuario actualizado correctamente.");
                    } else {
                        System.out.println("❌ Error al actualizar usuario.");
                    }
                    break;

                case 4:
                    System.out.print("ID del usuario a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine();

                    if (usuarioDAO.eliminarUsuario(idEliminar)) {
                        System.out.println("✅ Usuario eliminado correctamente.");
                    } else {
                        System.out.println("❌ Error al eliminar usuario.");
                    }
                    break;

                case 5:
                    System.out.print("ID del usuario a buscar: ");
                    int idBuscar = scanner.nextInt();
                    scanner.nextLine();

                    Usuario encontrado = usuarioDAO.obtenerUsuario(idBuscar);
                    if (encontrado != null) {
                        System.out.println("🔍 Usuario encontrado:\n" + encontrado);
                    } else {
                        System.out.println("⚠️ Usuario no encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("👋 Saliendo del sistema...");
                    break;

                default:
                    System.out.println("❗ Opción inválida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }
}
