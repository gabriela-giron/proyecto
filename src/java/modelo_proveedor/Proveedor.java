/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo_proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import modelo.conexion_bd;
/**
 *
 * @author jmess
 */
public class Proveedor extends Persona{
    
    
    private String codigo;
    private String direccion;
    private String correo;
    private conexion_bd cn;
    private int idproveedor;
    
    public Proveedor() {}

    public Proveedor(int idproveedor, String codigo, String nombre, String apellido, String direccion,String telefono, String correo) {
        super(nombre, apellido, telefono);
        this.codigo = codigo;
        this.direccion = direccion;
        this.correo = correo;
        this.idproveedor = idproveedor;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }
    
    
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
        cn = new conexion_bd();
        cn.abrir_conexion_bd();
        String query = "select * from proveedor;";
        ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
        String encabezado[]={"ID","Codigo","Nombre","Apellido","Direccion","Telefono","Correo"};
        tabla.setColumnIdentifiers(encabezado);
        String datos[] = new String [7];
        while (consulta.next()){
            datos[0] = consulta.getString("idproveedor");
            datos[1] = consulta.getString("codigoProveedor");
            datos[2] = consulta.getString("nombre");
            datos[3] = consulta.getString("apellido");
            datos[4] = consulta.getString("direccion");
            datos[5] = consulta.getString("telefono");
            datos[6] = consulta.getString("correo");
            
            tabla.addRow(datos);
        }
        
        cn.cerrar_conexion();
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
    }
      return tabla; 
    }
    @Override
   public int agregar(){
       int retorno = 0;
       try {
           PreparedStatement parametro;
           cn = new conexion_bd();
           String query="INSERT INTO proveedor(codigoProveedor, nombre, apellido, direccion, telefono, correo) VALUES (?,?,?,?,?,?);";
           cn.abrir_conexion_bd();
           parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
           parametro.setString(1, getCodigo());
           parametro.setString(2, getNombre());
           parametro.setString(3, getApellido());
           parametro.setString(4, getDireccion());
           parametro.setString(5, getTelefono());
           parametro.setString(6, getCorreo());
           
           retorno = parametro.executeUpdate();
           cn.cerrar_conexion();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
           retorno = 0;
       }
       return retorno;
   }
    @Override
   public int modificar(){ 
   int retorno = 0;
       try {
           PreparedStatement parametro;
           cn = new conexion_bd();
           String query="UPDATE proveedor SET codigoProveedor=?, nombre=?, apellido=?, direccion=?, telefono=?, correo=? WHERE id=?";
           cn.abrir_conexion_bd();
           parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
           parametro.setInt(1, getIdproveedor());
           
           retorno = parametro.executeUpdate();
           cn.cerrar_conexion();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
           retorno = 0;
       }
       return retorno;
   }
   
    @Override
   public int eliminar(){ 
   int retorno = 0;
       try {
           PreparedStatement parametro;
           cn = new conexion_bd();
           String query="DELETE FROM proveedor WHERE codigoProveedor=?";
           cn.abrir_conexion_bd();
           parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
           parametro.setInt(1, getIdproveedor());
           
           retorno = parametro.executeUpdate();
           cn.cerrar_conexion();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
           retorno = 0;
       }
       return retorno;
   }
    
    
}
