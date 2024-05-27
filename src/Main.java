import controllers.AuthController;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia del controlador de autenticación
        AuthController authController = new AuthController();
        
        // Mostrar el formulario de inicio de sesión
        authController.login();
    }
}
