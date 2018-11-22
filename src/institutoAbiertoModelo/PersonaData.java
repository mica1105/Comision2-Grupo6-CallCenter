/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutoAbiertoModelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vaio
 */
public class PersonaData {
    private Connection connection = null;
       
    public PersonaData (Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void guardarPersona (Persona persona) {
        
        try {
            String sql = "INSERT INTO persona (nombre, dni, celular) VALUES ( ? , ? , ? );";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, persona.getNombre());
            statement.setLong(2, persona.getDni());
            statement.setLong(3, persona.getCelular());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();
            
            if (rs.next()) {
                persona.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar una persona");
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar una persona: " + ex.getMessage());
        }
        
    }
    
    public List<Persona> obtenerPersonas(){
        
         List<Persona> personas = new ArrayList<Persona>();
        try {           
            String sql = "SELECT * FROM persona;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
           
           Persona persona;
            
            while(resultSet.next()){
                persona = new Persona();
                persona.setId(resultSet.getInt("id_Perona"));
                persona.setNombre(resultSet.getString("nombre"));
                persona.setDni(resultSet.getInt("dni"));
                persona.setCelular(resultSet.getInt("celular"));
                
                personas.add(persona);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener la persona: " + ex.getMessage());
        }
              
        return personas;             
    }

     public void borrarPersona(int id_Persona){
           try {
            
            String sql = "DELETE FROM persona WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_Persona);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un persona: " + ex.getMessage());
        }
            
    }
     public Persona buscarPersona(int id_Persona){
    Persona persona=null;
    try {
            
            String sql = "SELECT * FROM persona WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_Persona);
                       
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                persona = new Persona();
                persona.setId(resultSet.getInt("id_Persona"));
                persona.setNombre(resultSet.getString("nombre"));
                persona.setDni(resultSet.getInt("dni"));
                persona.setCelular(resultSet.getInt("celular"));                      
            }      
            statement.close();                 
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una persona: " + ex.getMessage());
        }
        
        return persona;
    }
}
    

