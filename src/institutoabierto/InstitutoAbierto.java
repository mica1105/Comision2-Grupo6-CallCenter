package institutoabierto;

import institutoAbiertoModelo.Conexion;
import institutoAbiertoModelo.Curso;
import institutoAbiertoModelo.CursoData;
import institutoAbiertoModelo.Matricula;
import institutoAbiertoModelo.MatriculaData;
import institutoAbiertoModelo.Persona;
import institutoAbiertoModelo.PersonaData;
import java.time.LocalDate;
import java.time.Month;

public class InstitutoAbierto {

    public static void main(String[] args) {

        Persona persona1 = new Persona("Mirta Becker", 32693062, 4390907);
        Conexion con = new Conexion();
        PersonaData pd = new PersonaData(con);

        pd.guardarPersona(persona1);

        System.out.println("Nueva Persona id: " + persona1.getId());

        Persona persona2 = new Persona(18,"Atenea Caselli", 33152586, 4365896);
        con = new Conexion();
        pd = new PersonaData(con);

        pd.guardarPersona(persona2);
 
        
        // TODO code application logic here
        Curso curso1 = new Curso(15,"Matematicas", "Sistema de ecuaciones", 500, 200, persona1);
        con = new Conexion();
        CursoData cd = new CursoData(con);
        
        cd.guardarCurso(curso1);
        

        System.out.println("Nuevo Curso id: " + curso1.getId());
        
        
        Matricula matricula1 = new Matricula (LocalDate.of(2018, Month.DECEMBER, 01), 200, persona2, curso1);
        con = new Conexion ();
                
        MatriculaData md = new MatriculaData(con);
        
        if(cd.hayDisponibilidad()){
        md.guardarMatricula(matricula1);
        } else{
            System.out.println("El Curso seleccionado no cuenta con cupo disponible");
        }
    }
}
