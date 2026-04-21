package com.mycompany.adolfo.controller;

import com.mycompany.adolfo.model.User;
import com.mycompany.adolfo.laboratorio2agonzalez.view.*;

public class UserController {
    
    //login lg = new login();
    Principal prc = new Principal();

    private final User admin = new User("agonzalezg69@miumg.edu.gt", "AdolfGrego2026!");
    private int intentos = 0;
    private boolean bloqueado = false;

    public String validarYAutenticar(String email, String pass) {
        System.out.println(email +" "+ pass);
        if (bloqueado) {
            System.out.println("SISTEMA_BLOQUEADO");
        }

        // 1. Validar que sea un correo (contenga @ y .)
        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("EMAIL_INVALIDO");
        }

        // 2. Validar contraseña mayor a 3 dígitos
        if (pass.length() <= 3) {
            System.out.println("PASSWORD_CORTO");
        }

        // 3. Autenticación
        if (email.equals(admin.getEmail()) && pass.equals(admin.getPassword())) {
            intentos = 0;
            prc.setVisible(true);
            System.out.println("EXITO");
        } else {
            intentos++;
            if (intentos >= 3) {
                bloqueado = true;
                System.out.println("SISTEMA_BLOQUEADO");
            }
            System.out.println("CREDENCIALES_INCORRECTAS");
        }
        return "asd";
    }

    public int getIntentosRestantes() {
        return 3 - intentos;
    }
}