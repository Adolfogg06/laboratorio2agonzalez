package com.mycompany.adolfo.controller;

import com.mycompany.adolfo.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserController {
    
    // 1. INSTANCIA ÚNICA (Singleton): Esto evita que los datos se borren al cambiar de ventana
    private static UserController instance;
    private List<User> usuarios = new ArrayList<>();
    private int intentos = 0;
    private boolean bloqueado = false;

    // 2. CONSTRUCTOR PRIVADO: Para que nadie más pueda hacer "new UserController()"
    private UserController() {
        usuarios.add(new User("Adolfo Gregorio", "agonzalezg69@miumg.edu.gt", "AdolfGrego2026!", "Admin", true));
        usuarios.add(new User("Pedro", "pedrinsky@miumg.edu.gt", "pdr2026@ppepe!", "user", true));
        usuarios.add(new User("Peter", "pdinklage@miumg.edu.gt", "pdin2123@umg!", "maestro", true));
    }

    // 3. MÉTODO PARA OBTENER LA INSTANCIA: Se usa en lugar del constructor
    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    // --- CRITERIO: Validación de Contraseña Segura (13 caracteres, Mayúscula, Signo) ---
    public boolean esPasswordSegura(String pass) {
        String regex = "^(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>]).{13,}$";
        return Pattern.matches(regex, pass);
    }
    
    public User buscarUsuario(String email) {
        for (User u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null; 
    }

    // --- CRITERIO: Autenticación ---
    public String autenticar(String email, String pass) {
        if (bloqueado) return "SISTEMA_BLOQUEADO";

        // Limpiamos los datos de entrada por seguridad
        String cleanEmail = email.trim();
        String cleanPass = pass.trim();

        for (User u : usuarios) {
            // Usamos equalsIgnoreCase para el correo y equals para la clave (las claves SI distinguen mayúsculas)
            if (u.getEmail().equalsIgnoreCase(cleanEmail) && u.getPassword().equals(cleanPass)) {
                if (!u.isActivo()) return "USUARIO_INACTIVO";
                intentos = 0;
                return u.getRole(); 
            }
        }

        intentos++;
        if (intentos >= 3) {
            bloqueado = true;
            return "SISTEMA_BLOQUEADO";
        }
        return "ERROR_CREDENCIALES";
    }

    // --- CRITERIO: CRUD ---
    public void agregarUsuario(String nombre, String email, String pass, String rol) {
        usuarios.add(new User(nombre, email, pass, rol, true));
    }

    public void modificarUsuario(String nombre, String emailOriginal, String nuevoPass, String nuevoRol) {
        for (User u : usuarios) {
            // Buscamos por el email original (el que se usó en el campo "Buscar")
            if (u.getEmail().equalsIgnoreCase(emailOriginal)) {
                u.setNombre(nombre);
                u.setPassword(nuevoPass);
                u.setRole(nuevoRol);
                // Si el usuario estaba inactivo, lo reactivamos al actualizar (opcional)
                u.setActivo(true); 
                break; 
            }
        }
    }

    public void setEstadoUsuario(String email, boolean estado) {
        for (User u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                u.setActivo(estado);
                break;
            }
        }
    }
    
    public void reiniciarPassword(String email, String nuevaPass) {
        User u = buscarUsuario(email);
        if (u != null) {
            u.setPassword(nuevaPass);
        }
    }

    public List<User> getUsuarios() { return usuarios; }
}