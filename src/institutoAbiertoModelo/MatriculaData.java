
package institutoAbiertoModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class MatriculaData {
  private Connection connection = null;

     private Conexion conexion;

    

     public MatriculaData (Conexion conexion){

         try {

          connection = conexion.getConexion();

        } catch (SQLException ex) {

            System.out.println("Error al abrir al obtener la conexion");

        }

     }

      public void guardarMatricula(Matricula matricula){

           

        try {

            String sql = "INSERT INTO matricula (fechaInscripcion, costo, idPersona, idCurso) VALUES ( ? , ? , ?, ? );";

           

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setDate(1, matricula.getFechaInscripcion());

            statement.setInt(2, matricula.getCosto());

            statement.setInt(3, matricula.getPersona().getId());

            statement.setInt(4, matricula.getCurso().getId());

           

             statement.executeUpdate();

            

              ResultSet rs = statement.getGeneratedKeys();

              if (rs.next()) {

                matricula.setId(rs.getInt(3));

                } else {

                System.out.println("No se pudo obtener el id luego de insertar una persona");

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

            matricula.setFechaInscripcion(resultSet.getDate("fechaInscripcion"));

            matricula.setCosto(resultSet.getInt("costo"));

           

            Persona p = buscarPersona(resultSet.getInt("idPersona"));

            matricula.setPersona(p);

            Curso c = buscarCurso(resultSet.getInt("idCurso"));

            matricula.setCurso(c);

           

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

    

     public List<Matricula> obtenerMatriculaXPersona(int id){

        List<Matricula> matriculas = new ArrayList<Matricula>();

       

         try {

        String sql = "SELECT * FROM matricula WHERE idPersona = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1,id);

            ResultSet resultSet = statement.executeQuery();

            Matricula matricula;

            while(resultSet.next()){

                matricula = new Matricula();

                matricula.setId(resultSet.getInt("id"));

                matricula.setId(resultSet.getInt("id"));

                matricula.setFechaInscripcion(resultSet.getDate("fechaInscripcion"));

                matricula.setCosto(resultSet.getInt("costo"));

               

             Persona p = buscarPersona(resultSet.getInt("idPersona"));

             matricula.setPersona(p);

             Curso c = buscarCurso(resultSet.getInt("idCurso"));

             matricula.setCurso(c);

            

             matriculas.add(matricula);

            }

            statement.close();

        } catch (SQLException ex) {

            System.out.println("Error: " + ex.getMessage());

        }

        return matriculas;       
}
}

