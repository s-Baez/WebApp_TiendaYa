import DAO.Conexion;

public class Main {
    public static void main(String[] args) {
        boolean isConnected = Conexion.probarConexion();
        if (isConnected) {
            System.out.println("Conexión exitosa a la base de datos.");
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
    }
}