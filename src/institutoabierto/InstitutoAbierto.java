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

        Persona persona1 = new Persona("Antonelo Lopez", 32569895, 4785821);
        Conexion con = new Conexion();
        PersonaData pd = new PersonaData(con);

        pd.guardarPersona(persona1);

        System.out.println("Nueva Persona id: " + persona1.getId());

        Persona persona2 = new Persona("Lucia Gomez", 32569854, 4785201);
        con = new Conexion();
        pd = new PersonaData(con);

        pd.guardarPersona(persona2);
        
        Persona persona3 = new Persona("Nicolas Martinez", 28569859, 4258963);
        con = new Conexion();
        pd = new PersonaData(con);

        pd.guardarPersona(persona3);
 
        
        // TODO code application logic here
        Curso curso1 = new Curso("Matematicas", "Sistema de ecuaciones", 25, 200, persona1);
        con = new Conexion();
        CursoData cd = new CursoData(con);
        
        cd.guardarCurso(curso1);
        
        Curso curso2 = new Curso ("Lengua y Literatura", "Textos expositivos", 20, 150, persona2);
        con = new Conexion();
        cd = new CursoData(con);
        
        cd.guardarCurso(curso2);
        

        System.out.println("Nuevo Curso id: " + curso1.getId());
        
        
        Matricula matricula1 = new Matricula (LocalDate.of(2018, Month.DECEMBER, 01), 200, persona3, curso1);
        con = new Conexion ();
                
        MatriculaData md = new MatriculaData(con);
        
        if(cd.hayDisponibilidad(curso1.getId())){
        md.guardarMatricula(matricula1);
        } else{
            System.out.println("El Curso seleccionado no cuenta con cupo disponible");
        }
       
    }
}
