package com.mycompany.adolfo.model;

public class User {
    private String email;
    private String password;
    private String role;     // Ejemplo: "Admin", "Operador"
    private boolean activo;  // Para el requisito de "Inactivar usuarios"

    // Constructor completo
    public User(String email, String password, String role, boolean activo) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.activo = activo;
    }

    // --- Getters y Setters ---
    // Los Setters son vitales para la parte de "Modificar" y "Reinicio de Clave"
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}