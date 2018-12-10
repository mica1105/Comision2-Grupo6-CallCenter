
package institutoAbiertoModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CursoData {
 private Connection connection = null;
    private Conexion conexion;

    public CursoData(Conexion conexion) {

        try {

            connection = conexion.getConexion();

        } catch (SQLException ex) {

            System.out.println("Error al abrir al obtener la conexion");

        }

    }

    public void guardarCurso (Curso curso){

        try {

            String sql = "INSERT INTO curso (nombre, descripcion, cupo, costo, id_persona) VALUES ( ? , ? , ? , ? , ?);";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, curso.getNombre());

            statement.setString(2, curso.getDescripcion());

            statement.setInt(3, curso.getCupo());

            statement.setInt(4, curso.getCosto());

            statement.setInt(5, curso.getPersona().getId());

           

            statement.executeUpdate();

           

            ResultSet rs = statement.getGeneratedKeys();

           
           
            if (rs.next()) {

                curso.setId(rs.getInt(1));

            } else {

                System.out.println("No se pudo obtener el id luego de insertar un curso");

            }

            statement.close();

        } catch (SQLException ex) {

            System.out.println("Error al insertar un curso: " + ex.getMessage());

        }

          

}

     public List<Curso> obtenerCursos(){

      

            List<Curso>Cursos = new ArrayList<Curso>();

            try {

            String sql = "SELECT * FROM curso;";

            PreparedStatement statement = connection.prepareStatement(sql);          

            ResultSet resultSet = statement.executeQuery();

            Curso curso;

           

            while(resultSet.next()){

                curso = new Curso();

                curso.setId(resultSet.getInt("id"));

                curso.setNombre(resultSet.getString("nombre"));

                curso.setDescripcion(resultSet.getString("descripcion"));

                curso.setCupo(resultSet.getInt("cupo"));

                curso.setCosto(resultSet.getInt("costo"));

               

                Persona p = buscarPersona(resultSet.getInt("id_persona"));

                curso.setPersona(p);

               

                Cursos.add(curso);

            }

            statement.close();

            } catch (SQLException ex) {

           System.out.println("Error al obtener el curso: " + ex.getMessage());

        }

            return Cursos;

       

}

     public List<Curso> obtenerCursosXPersona(int id_persona) {

      

            List<Curso> cursos = new ArrayList<Curso>();

      try {

                

            String sql = "SELECT * FROM curso WHERE id_Persona = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1,id_persona);

            ResultSet resultSet = statement.executeQuery();

            Curso curso;

            while(resultSet.next()){

                curso = new Curso ();

                curso.setId(resultSet.getInt("id_Persona"));

                curso.setNombre(resultSet.getString("nombre"));

                curso.setDescripcion(resultSet.getString("descripcion"));

                curso.setCupo(resultSet.getInt("cupo"));

                curso.setCosto(resultSet.getInt("costo"));

                Persona p=buscarPersona(resultSet.getInt("id_Persona"));

                curso.setPersona(p);

               

                cursos.add(curso);

            }

            statement.close();

        } catch (SQLException ex) {

           System.out.println("Error al obtener los cursos: " + ex.getMessage());

        }

      return cursos;

     

     }

     public Persona buscarPersona(int id_persona){

   

        PersonaData pd=new PersonaData(conexion);

       

        return pd.buscarPersona(id_persona);

    

     }

     public Curso buscarCurso (int id_curso){

         Curso curso=null;

         try {

         String sql = "SELECT * FROM curso WHERE id_curso =?;";

         

     PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

     statement.setInt(1, id_curso);

                

       ResultSet resultSet=statement.executeQuery();

                

                 while(resultSet.next()){

                     curso = new Curso();

                     curso.setId(resultSet.getInt("id"));

                     curso.setNombre(resultSet.getString("nombre"));

                     curso.setDescripcion(resultSet.getString("descripcion"));

                     curso.setCupo(resultSet.getInt("cupo"));

                     curso.setCosto(resultSet.getInt("costo"));

                    

                 }

                

                 statement.close();

         } catch (SQLException ex) {

            System.out.println("Error al insertar: " + ex.getMessage());

        }

        return curso; 

}
     public boolean hayDisponibilidad(int id_Curso){
          
   
         
         int cupo = 0;
         int cantMat = 0;
         
         try {
             
         String sql =  "SELECT COUNT(*) FROM curso, matricula WHERE curso.id_Curso = matricula.id_Curso AND curso.id_Curso = ?;";     
         PreparedStatement statement = connection.prepareStatement(sql);
         statement.setInt(1,id_Curso);
         
         ResultSet rs = statement.executeQuery();
         
         rs.next();
         
         cantMat = rs.getInt(1);
         
         sql = "SELECT cupo FROM curso WHERE curoso.id_Curso=?;";
         rs = statement.executeQuery();
         rs.next();
         
         cupo = rs.getInt(1);
         
        
     } catch (SQLException ex) {
         Logger.getLogger(CursoData.class.getName()).log(Level.SEVERE, null, ex);
     }
     return cantMat < cupo;
     
}
     }