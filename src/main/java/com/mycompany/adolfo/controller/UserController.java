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
        // Usuario inicial requerido para poder entrar
        usuarios.add(new User("agonzalezg69@miumg.edu.gt", "AdolfGrego2026!", "Admin", true));
        usuarios.add(new User("pedrinsky@miumg.edu.gt", "pdr2026@ppepe!", "user", true));
        usuarios.add(new User("pdinklage@miumg.edu.gt", "pdin2123@umg!", "maestro", true));
    }

    // --- CRITERIO: Validación de Contraseña Segura ---
    public boolean esPasswordSegura(String pass) {
        // 13 caracteres, 1 mayúscula, 1 signo especial
        String regex = "^(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>]).{13,}$";
        return Pattern.matches(regex, pass);
    }

    // --- CRITERIO: Autenticación ---
    public String autenticar(String email, String pass) {
        if (bloqueado) return "SISTEMA_BLOQUEADO";

        for (User u : usuarios) {
            if (u.getEmail().equals(email) && u.getPassword().equals(pass)) {
                if (!u.isActivo()) return "USUARIO_INACTIVO";
                intentos = 0;
                return "EXITO";
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
    public void agregarUsuario(String email, String pass, String rol) {
        usuarios.add(new User(email, pass, rol, true));
    }

    public void modificarUsuario(String email, String nuevoPass, String nuevoRol) {
        for (User u : usuarios) {
            if (u.getEmail().equals(email)) {
                u.setPassword(nuevoPass);
                u.setRole(nuevoRol);
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