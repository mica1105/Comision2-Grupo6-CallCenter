
package institutoAbiertoModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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

            String sql = "INSERT INTO curso (nombre, descripcion, cupo, costo, persona) VALUES ( ? , ? , ? , ? , ?);";

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

               

                Persona p = buscarPersona(resultSet.getInt("idpersona"));

                curso.setPersona(p);

               

                Cursos.add(curso);

            }

            statement.close();

            } catch (SQLException ex) {

           System.out.println("Error al obtener el curso: " + ex.getMessage());

        }

            return Cursos;

       

}

     public List<Curso> obtenerCursosXPersona(int id) {

      

            List<Curso> cursos = new ArrayList<Curso>();

      try {

                

            String sql = "SELECT * FROM curso WHERE idPersona = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1,id);

            ResultSet resultSet = statement.executeQuery();

            Curso curso;

            while(resultSet.next()){

                curso = new Curso ();

                curso.setId(resultSet.getInt("id"));

                curso.setNombre(resultSet.getString("nombre"));

                curso.setDescripcion(resultSet.getString("descripcion"));

                curso.setCupo(resultSet.getInt("cupo"));

                curso.setCosto(resultSet.getInt("costo"));

                Persona p=buscarPersona(resultSet.getInt("idPersona"));

                curso.setPersona(p);

               

                cursos.add(curso);

            }

            statement.close();

        } catch (SQLException ex) {

           System.out.println("Error al obtener los cursos: " + ex.getMessage());

        }

      return cursos;

     

     }

     public Persona buscarPersona(int id){

   

        PersonaData pd=new PersonaData(conexion);

       

        return pd.buscarPersona(id);

    

     }

     public Curso buscarCurso (int id){

         Curso curso=null;

         try {

         String sql = "SELECT * FROM curso WHERE id =?;";

         

     PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

     statement.setInt(1, id);

                

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
}
