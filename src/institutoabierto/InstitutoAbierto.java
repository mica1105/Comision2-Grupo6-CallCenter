
package institutoabierto;

import institutoAbiertoModelo.Conexion;
import institutoAbiertoModelo.Curso;
import institutoAbiertoModelo.CursoData;
import institutoAbiertoModelo.Persona;
import institutoAbiertoModelo.PersonaData;


public class InstitutoAbierto {

    
    public static void main(String[] args) {
    
    Persona persona1 = new Persona ("Mirta Becker", 32693062, 4390907);   
    Conexion con = new Conexion ();
    PersonaData pd = new PersonaData (con);
    
    
     pd.guardarPersona(persona1);
     
     System.out.println("Nueva Persona id: "+persona1.getId());
     
        
     // TODO code application logic here
    }
}

