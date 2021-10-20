/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo_cliente;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import modelo_proveedor.Persona;
import modelo.conexion_bd;

/**
 *
 * @author Luyi_
 */
public class clientes extends Persona{
    private String nit;
    private String direccion;
    private int idclientes;
    
    conexion_bd cn;
    public clientes(){}

    public clientes(int idclientes, String nombre, String apellido, String direccion, String telefono, String nit) {
        super(nombre, apellido, telefono);
        this.nit = nit;
        this.direccion = direccion;
        this.idclientes = idclientes;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdclientes() {
        return idclientes;
    }

    public void setIdclientes(int idclientes) {
        this.idclientes = idclientes;
    }
    
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
        cn = new conexion_bd();
        cn.abrir_conexion_bd();
        String query = "select * from clientes;";
        ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
        String encabezado[]={"ID","Nombre","Apellido","Direccion","Telefono","Nit"};
        tabla.setColumnIdentifiers(encabezado);
        String datos[] = new String [6];
        while (consulta.next()){
            datos[0] = consulta.getString("idclientes");
            datos[1] = consulta.getString("nombre");
            datos[2] = consulta.getString("apellido");
            datos[3] = consulta.getString("direccion");
            datos[4] = consulta.getString("telefono");
            datos[5] = consulta.getString("nit");
            
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
       try{
         PreparedStatement parametro;
         cn = new conexion_bd();
         cn.abrir_conexion_bd();
         String query = "insert into clientes(nombre, apellido, direccion, telefono, nit)VALUES(?,?,?,?,?);";
         parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
         parametro.setString(1, getNombre());
         parametro.setString(2, getApellido());
         parametro.setString(3, getDireccion());
         parametro.setString(4, getTelefono());
         parametro.setString(5, getNit());

         retorno = parametro.executeUpdate();
         cn.cerrar_conexion();
         
        }catch (SQLException ex){
         System.out.println("!!!!!!Error Fatal Conexion Invalida" + ex.getMessage());
         return 0;
    }
      return retorno; 
  }
    
}
