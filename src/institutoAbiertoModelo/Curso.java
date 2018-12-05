
package institutoAbiertoModelo;

public class Curso {
    private int id= -1;
    private String nombre;
    private String descripcion;
    private int cupo;
    private int costo;
    private Persona persona;

    public Curso(int id, String nombre, String descripcion, int cupo, int costo, Persona persona) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cupo = cupo;
        this.costo = costo;
        this.persona = persona;
    }

    public Curso(String nombre, String descripcion, int cupo, int costo, Persona persona) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cupo = cupo;
        this.costo = costo;
        this.persona = persona;
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

    public Persona getPersona() {
        return persona;
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

    public void setPersona(Persona persona) {
        this.persona = persona;
 }    
    @Override
    public String toString(){
    
        return id+"-"+nombre;
    }
}
