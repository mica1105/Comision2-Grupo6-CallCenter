
package institutoAbiertoModelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class MatriculaData {
     private Connection connection = null;
     private Conexion conexion;

    
     public MatriculaData (Conexion conexion){
          try {
         this.conexion=conexion;
         connection = conexion.getConexion();
        
        this.conexion=conexion;} catch (SQLException ex) {

            System.out.println("Error al abrir al obtener la conexion");

        }

     }

      public void guardarMatricula(Matricula matricula){

           

        try {

            String sql = "INSERT INTO matricula (fechaInscripcion, costo, id_Persona, id_Curso) VALUES ( ? , ? , ?, ? );";

           

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setDate(1, Date.valueOf(matricula.getFechaInscripcion()));

            statement.setInt(2, matricula.getCosto());

            statement.setInt(3, matricula.getPersona().getId());

            statement.setInt(4, matricula.getCurso().getId());

           
             statement.executeUpdate();
            
             
              ResultSet rs = statement.getGeneratedKeys();
              
              
            
              if (rs.next()){
                  
                matricula.setId(rs.getInt(1));

                } else {

                System.out.println("No se encontre el id de la persona");

            }

            statement.close();

           

        } catch (SQLException ex) {

            System.out.println("Error al insertar una persona: " + ex.getMessage());

        }

     

   }

   public List<Matricula> obtenerMatriculas(){

   

            List<Matricula> matriculas = new ArrayList<Matricula>();
          

     try {

            String sql = "SELECT * FROM matricula;";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            Matricula matricula;

           

        while(resultSet.next()){

            matricula = new Matricula();

            matricula.setId(resultSet.getInt("id"));

            matricula.setFechaInscripcion(resultSet.getDate("fechaInscripcion").toLocalDate());

            matricula.setCosto(resultSet.getInt("costo"));

           

            Persona p = buscarPersona(resultSet.getInt("id_Persona"));

            matricula.setPersona(p);

            Curso c = buscarCurso(resultSet.getInt("id_Curso"));

            matricula.setCurso(c);

           

            matriculas.add(matricula);

        }

             statement.close();

           

            } catch (SQLException ex) {

            System.out.println("Error: " + ex.getMessage());

        }

           

         return matriculas;

        

     }

  
     public List<Matricula> obtenerMatriculaXPersona(int id){

        List<Matricula> matriculas = new ArrayList<Matricula>();

       

         try {

        String sql = "SELECT * FROM matricula WHERE id_Persona = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1,id);

            ResultSet resultSet = statement.executeQuery();

            Matricula matricula;

            while(resultSet.next()){

                matricula = new Matricula();

                matricula.setId(resultSet.getInt("id"));

                matricula.setId(resultSet.getInt("id"));

               matricula.setFechaInscripcion(resultSet.getDate("fechaInscripcion").toLocalDate());

                matricula.setCosto(resultSet.getInt("costo"));

               

             Persona p = buscarPersona(resultSet.getInt("id_Persona"));

             matricula.setPersona(p);

             Curso c = buscarCurso(resultSet.getInt("id_Curso"));

             matricula.setCurso(c);

            

             matriculas.add(matricula);

            }

            statement.close();

        } catch (SQLException ex) {

            System.out.println("Error: " + ex.getMessage());

        }

        return matriculas;       
}
     
     public List<Matricula> obtenerMatriculasXCurso(int id){

            List<Matricula> matriculas = new ArrayList<Matricula>();
          

     try {

            String sql = "SELECT * FROM matricula WHERE id_Curso = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            Matricula matricula;

           

        while(resultSet.next()){

            matricula = new Matricula();

            matricula.setId(resultSet.getInt("id"));

            matricula.setFechaInscripcion(resultSet.getDate("fechaInscripcion").toLocalDate());

            matricula.setCosto(resultSet.getInt("costo"));
       
            
            Curso c = buscarCurso(resultSet.getInt("id_Curso"));

             matricula.setCurso(c);
             
             Persona p = buscarPersona(resultSet.getInt("id_Persona"));

            matricula.setPersona(p);

           
            matriculas.add(matricula);

        }

             statement.close();

           

            } catch (SQLException ex) {

            System.out.println("Error: " + ex.getMessage());

        }

           

         return matriculas;

        

     }
      public Persona buscarPersona (int id) {

     PersonaData pd = new PersonaData (conexion);

     return pd.buscarPersona(id);

}

 

     public Curso buscarCurso(int id){

     CursoData cd=new CursoData(conexion);

     return cd.buscarCurso(id);

}
     public void borrarMatriculaDeUnCursoDeunaPersona(int id_Persona,int id_Curso){
    
        try {
            
            String sql = "DELETE FROM matricula WHERE id_Persona =? and id_Curso =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_Persona);
            statement.setInt(2, id_Curso);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar persona: " + ex.getMessage());
        }
        
    }
     

}


