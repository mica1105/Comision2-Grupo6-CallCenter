/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutoAbiertoModelo;

/**
 *
 * @author Vaio
 */
public class Persona {
    private int id = -1;
    private String nombre;
    private int dni;
    private int celular;

    public Persona(int id, String nombre, int dni, int celular) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.celular = celular;
    }

    public Persona(String nombre, int dni, int celular) {
        this.id = -1;
        this.nombre = nombre;
        this.dni = dni;
        this.celular = celular;
    }
    public Persona (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }
    
}