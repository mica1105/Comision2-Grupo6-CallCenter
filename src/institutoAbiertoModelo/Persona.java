
package institutoAbiertoModelo;

public class Persona {
    private int id=-1;
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
    
    public Persona (int id){
            this.id = id;
    }
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
    @Override
     public String toString(){
    
        return id+"-"+nombre;
    }
    
}