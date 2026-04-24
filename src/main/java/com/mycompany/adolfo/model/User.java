package com.mycompany.adolfo.model;

public class User {
    private String nombre;   // Nueva variable
    private String email;
    private String password;
    private String role;     
    private boolean activo;  

    // Constructor actualizado con 'nombre'
    public User(String nombre, String email, String password, String role, boolean activo) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.role = role;
        this.activo = activo;
    }

    // --- Getters y Setters ---

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}