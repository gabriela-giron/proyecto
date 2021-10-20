/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Keren
 */
public class conexion_bd {
    public Connection conexionBD;
    public final String bd = "bd_idream";
    public final String urlConexion = String.format("jdbc:mysql://localhost:3306/%s",bd);
    public final String usuario = "keren";
    public final String contra = "demetria1245";
    public final String jdbc = "com.mysql.cj.jdbc.Driver";
    
    public Connection abrir_conexion_bd(){
        try{
            Class.forName(jdbc);
            conexionBD = DriverManager.getConnection(urlConexion,usuario,contra);
            
        }catch(Exception ex){//si el codigo da error, el catch lo agarra para que no nos de un error enorme
        }
     return conexionBD;
    }
    
    public void cerrar_conexion(){    
    
    try{
        conexionBD.close();
    }
     catch(Exception e){  
    }
}
    
}
    





   