/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutoAbiertoModelo;

import java.time.LocalDate;

/**
 *
 * @author Vaio
 */
public class Matricula {
    private int id=-1;
    private LocalDate fechaInscripcion;
    private int costo;
    private Persona persona;
    private Curso curso;

    public Matricula(LocalDate fechaInscripcion, int costo, Persona persona, Curso curso) {
        this.fechaInscripcion = fechaInscripcion;
        this.costo = costo;
        this.persona = persona;
        this.curso = curso;
    }

    public Matricula(int id, LocalDate fechaInscripcion, int costo, Persona persona, Curso curso) {
        this.id = id;
        this.fechaInscripcion = fechaInscripcion;
        this.costo = costo;
        this.persona = persona;
        this.curso = curso;
    }
    
    public Matricula () {}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
 
}