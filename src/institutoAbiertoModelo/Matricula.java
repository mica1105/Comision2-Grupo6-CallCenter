
package institutoAbiertoModelo;

import java.sql.Date;


public class Matricula {
    private int id=-1;
    private Date fechaInscripcion;
    private int costo;
    private Persona persona;
    private Curso curso;

    public Matricula(Date fechaInscripcion, int costo, Persona persona, Curso curso) {
        this.fechaInscripcion = fechaInscripcion;
        this.costo = costo;
        this.persona = persona;
        this.curso = curso;
    }

    public Matricula(int id, Date fechaInscripcion, int costo, Persona persona, Curso curso) {
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

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
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