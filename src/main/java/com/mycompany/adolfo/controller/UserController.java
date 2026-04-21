package com.mycompany.adolfo.controller;

import com.mycompany.adolfo.model.User;

public class UserController {
    
    private final User admin = new User("agonzalezg69@miumg.edu.gt", "AdolfGrego2026!");
    private int intentos = 0;
    private boolean bloqueado = false;

    public String validarYAutenticar(String email, String pass) {
        if (bloqueado) {
            return "BLOQUEADO";
        }

        // 1. Validar formato de correo
        if (!email.contains("@") || !email.contains(".")) {
            return "EMAIL_INVALIDO";
        }

        // 2. Validar longitud de contraseña
        if (pass.length() <= 3) {
            return "PASSWORD_CORTO";
        }

        // 3. Lógica de Autenticación
        if (email.equals(admin.getEmail()) && pass.equals(admin.getPassword())) {
            intentos = 0;
            return "EXITO";
        } else {
            intentos++;
            if (intentos >= 3) {
                bloqueado = true;
                return "BLOQUEADO";
            }
            return "INCORRECTO";
        }
    }

    public int getIntentosRestantes() {
        return 3 - intentos;
    }
}