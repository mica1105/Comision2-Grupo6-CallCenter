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
public class Curso {
    private int id= -1;
    private String nombre;
    private String descripcion;
    private int cupo;
    private int costo;
    private Persona responsable;

    public Curso(int id, String nombre, String descripcion, int cupo, int costo, Persona responsable) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cupo = cupo;
        this.costo = costo;
        this.responsable = responsable;
    }

    public Curso(String nombre, String descripcion, int cupo, int costo, Persona responsable) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cupo = cupo;
        this.costo = costo;
        this.responsable = responsable;
    }
    
    public Curso () {}    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCupo() {
        return cupo;
    }

    public int getCosto() {
        return costo;
    }

    public Persona getResponsable() {
        return responsable;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public void setResponsable(Persona responsable) {
        this.responsable = responsable;
    }
          
    
}
