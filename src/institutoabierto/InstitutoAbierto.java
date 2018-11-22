/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutoabierto;

import institutoAbiertoModelo.Conexion;
import institutoAbiertoModelo.Persona;
import institutoAbiertoModelo.PersonaData;

/**
 *
 * @author Vaio
 */
public class InstitutoAbierto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    Persona persona1 = new Persona ("Mirta Becker", 32693062, 4390907);   
    Conexion con = new Conexion ();
    PersonaData pd = new PersonaData (con);
    
    
     pd.guardarPersona(persona1);
     
     System.out.println("Nueva Persona id: "+persona1.getId());
        
     // TODO code application logic here
    }
}

