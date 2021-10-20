/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import modelo_proveedor.Persona;

/**
 *
 * @author E7440
 */
public class Users extends Persona {
    private int idusers, id_grupo;
    private String username, password;
    private grupos grupos;
    private boolean estado;
    private conexion_bd cn;
    
    public Users(){
    }
    public Users(int idusers, String nombre, String apellido, String telefono, String username, String password, boolean estado, int id_grupo ){
        super(nombre, apellido, telefono);
        this.username = username;
        this.password = password;
        this.estado = estado;
        this.id_grupo = id_grupo;
        this.grupos = grupos;
    }
    
    



public int getIdusers(){
        return idusers;
    }
    
    public void setIdusers(int idusers){
        this.idusers = idusers;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
     public grupos getGrupos() {
        return grupos;
    }

    public void setGrupos(grupos grupos) {
        this.grupos = grupos;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }
    
    
    
    public DefaultTableModel leer(){
        DefaultTableModel table = new DefaultTableModel();
        try{
            cn = new conexion_bd();
            cn.abrir_conexion_bd();
            String query ="select * from users;";
            /*String query = "select u.idusuarios, u.username, g.nombre_grupo from usuarios u "
                    + "inner join grupos g on u.id_grupo = g.id_grupo "
                    + "where u.estado = 1;";*/
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[]={"idusuarios","Nombres","Apellido","Telefono","Nombre de Usuario","Contraseña","Estado","Puesto"};
            table.setColumnIdentifiers(encabezado);
            String datos[] = new String [7];
            while (consulta.next()){
                datos[0] = consulta.getString("idusers");
                datos[1] = consulta.getString("nombre");
                datos[2] = consulta.getString("apellido");
                datos[3] = consulta.getString("telefono");
                datos[4] = consulta.getString("username");
                datos[5] = consulta.getString("password");
                datos[6] = consulta.getString("estado");
                datos[7] = consulta.getString("id_grupo");
            
                table.addRow(datos);
            }
             cn.cerrar_conexion();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return table;
    }
    
   public int agregar(){
       int retorno = 0;
       try {
           PreparedStatement parametro;
           cn = new conexion_bd();
           String query="insert into users(nombre,apellido,telefono,username,password,estado,id_grupo)valuesVALUES (?,?,?,?,?,?,?);";
           cn.abrir_conexion_bd();
           parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
           parametro.setString(1, getNombre());
           parametro.setString(2, getApellido());
           parametro.setString(3, getTelefono());
           parametro.setString(4, getUsername());
           parametro.setString(5, getPassword());
           parametro.setBoolean(6, isEstado());
           parametro.setInt(7, getId_grupo());
           
           retorno = parametro.executeUpdate();
           cn.cerrar_conexion();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
           retorno = 0;
       }
       return retorno;
   }
   /*
   public int modificar(){ 
   int retorno = 0;
       try {
           PreparedStatement parametro;
           cn = new conexion_bd();
           String query="UPDATE proveedor SET codigoProveedor=?, nombre=?, apellido=?, direccion=?, telefono=?, correo=? WHERE id=?";
           cn.abrir_conexion_bd();
           parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
           parametro.setInt(1, getIdusuarios());
           
           retorno = parametro.executeUpdate();
           cn.cerrar_conexion();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
           retorno = 0;
       }
       return retorno;
   }
   
    public int eliminar(){ 
   int retorno = 0;
       try {
           PreparedStatement parametro;
           cn = new conexion_bd();
           String query="DELETE FROM proveedor WHERE idusuarios=?";
           cn.abrir_conexion_bd();
           parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
           parametro.setInt(1, getIdusuarios());
           
           retorno = parametro.executeUpdate();
           cn.cerrar_conexion();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
           retorno = 0;
       }
       return retorno;
    }*/
}

