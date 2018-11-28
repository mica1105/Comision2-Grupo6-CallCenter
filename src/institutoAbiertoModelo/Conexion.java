
package institutoAbiertoModelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    private String url="jdbc:mysql://localhost/InstitutoAbierto";
    private String usuario="root";
    private String password="";
    
    private Connection conexion=null;
    
    public Conexion(String url, String usuario, String password) throws ClassNotFoundException {
        this.url = url;
        this.usuario = usuario;
        this.password = password;

       //Cargamos las clases de mariadb que implementan JDBC
        Class.forName("org.mariadb.jdbc.Driver");

    }
    
    public Conexion (){};
    public Connection getConexion() throws SQLException{
        if(conexion == null){
                    // Setup the connection with the DB
            conexion = DriverManager
                .getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                        + "&user=" + usuario + "&password=" + password);
        }
        return conexion;
    }
    
}
