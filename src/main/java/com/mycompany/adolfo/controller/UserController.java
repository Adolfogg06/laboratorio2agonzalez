package com.mycompany.adolfo.controller;

import com.mycompany.adolfo.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserController {
    private List<User> usuarios = new ArrayList<>();
    private int intentos = 0;
    private boolean bloqueado = false;

    public UserController() {
        // Añadimos el nombre como primer parámetro
        usuarios.add(new User("Adolfo Gregorio", "agonzalezg69@miumg.edu.gt", "AdolfGrego2026!", "Admin", true));
        usuarios.add(new User("Pedro", "pedrinsky@miumg.edu.gt", "pdr2026@ppepe!", "user", true));
        usuarios.add(new User("Peter", "pdinklage@miumg.edu.gt", "pdin2123@umg!", "maestro", true));
    }
    public void reiniciarPassword(String email, String nuevaPass) {
        User u = buscarUsuario(email);
        if (u != null) {
            u.setPassword(nuevaPass);
        }
    }

    // --- CRITERIO: Validación de Contraseña Segura ---
    public boolean esPasswordSegura(String pass) {
        // 13 caracteres, 1 mayúscula, 1 signo especial
        String regex = "^(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>]).{13,}$";
        return Pattern.matches(regex, pass);
    }
    
    public User buscarUsuario(String email) {
        for (User u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null; // Si no existe
    }

    // --- CRITERIO: Autenticación Mejorada ---
    public String autenticar(String email, String pass) {
        if (bloqueado) return "SISTEMA_BLOQUEADO";

        for (User u : usuarios) {
            if (u.getEmail().equals(email) && u.getPassword().equals(pass)) {
                if (!u.isActivo()) return "USUARIO_INACTIVO";
                intentos = 0;
                // DEVOLVEMOS EL ROL: "Admin", "Maestro" o "User"
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

    // --- CRITERIO: Mantenimiento (CRUD) ---
    public void agregarUsuario(String nombre, String email, String pass, String rol) {
        usuarios.add(new User(nombre, email, pass, rol, true));
    }

    public void modificarUsuario(String nombre, String emailOriginal, String nuevoPass, String nuevoRol) {
        for (User u : usuarios) {
            // Buscamos por el email que el usuario NO cambió (el de la búsqueda)
            if (u.getEmail().equalsIgnoreCase(emailOriginal)) {
                u.setNombre(nombre);
                u.setPassword(nuevoPass);
                u.setRole(nuevoRol);
                break; 
            }
        }
    }

    public void setEstadoUsuario(String email, boolean estado) {
        for (User u : usuarios) {
            if (u.getEmail().equals(email)) u.setActivo(estado);
        }
    }
    
    public List<User> getUsuarios() { return usuarios; }
}