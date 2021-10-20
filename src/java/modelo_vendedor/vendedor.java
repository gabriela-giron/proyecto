/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo_vendedor;

import modelo.conexion_bd;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import modelo_proveedor.Persona;
/**
 *
 * @author HP14DQ0006LA
 */
public class vendedor extends Persona{
    private int idvendedor;
    private String cod_vendedor, direccion; 
    
    private conexion_bd cn;
    
    public vendedor(){};
    public vendedor(int idvendedor, String cod_vendedor, String nombre, String apellido, String telefono, String direccion) {
        super(nombre, apellido, telefono);
        this.idvendedor = idvendedor;
        this.cod_vendedor = cod_vendedor;
        this.direccion = direccion;
    }
    
    public int getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }

    public String getCod_vendedor() {
        return cod_vendedor;
    }

    public void setCod_vendedor(String cod_vendedor) {
        this.cod_vendedor = cod_vendedor;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
       cn = new conexion_bd();
       cn.abrir_conexion_bd();
       String query = "select * from vendedores;";
       ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
       String encabezado[] = {"id","codigo","nombres","apellidos","telefono","direccion"};
       tabla.setColumnIdentifiers(encabezado);
       String datos[] = new String[6];
       while(consulta.next()){
           datos[0] = consulta.getString("idvendedor");
           datos[1] = consulta.getString("cod_vendedor");
           datos[2] = consulta.getString("nombre");
           datos[3] = consulta.getString("apellido");
           datos[4] = consulta.getString("telefono");
           datos[5] = consulta.getString("direccion");
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
       int retorno=0; 
       try{
       PreparedStatement parametro;
         cn = new conexion_bd();
         String query = "INSERT INTO vendedores (codigo_vendedor,nombre,apellido,telefono,direccion) VALUES(?,?,?,?,?);";
         
         cn.abrir_conexion_bd();
         parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setString(1, getCod_vendedor());
         parametro.setString(2, getNombre());
         parametro.setString(3, getApellido());
         parametro.setString(4, getTelefono());
         parametro.setString(5, getDireccion());
         
         retorno = parametro.executeUpdate();
         cn.cerrar_conexion();
         
        }catch (SQLException ex){
         System.out.println("Error..." + ex.getMessage());
         return 0;
    }
       return retorno;
    }
     
    @Override
    public int modificar (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new conexion_bd();
            String query = "update vendedores set codigo_vendedor = ?, nombres= ?, apellidos= ?, telefono= ?, direccion= ? where idvendedor = ?;";

         cn.abrir_conexion_bd();
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
         parametro.setInt(1, getIdvendedor());

            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    @Override
    public int eliminar (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new conexion_bd();
            String query = "delete from vendedores where idvendedor = ?;";
            cn.abrir_conexion_bd();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getIdvendedor());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }

}