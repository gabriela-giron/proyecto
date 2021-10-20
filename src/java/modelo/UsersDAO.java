/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author E7440
 */
public class UsersDAO extends conexion_bd{
    Users use = null;
    conexion_bd con;
    Connection cn = null; 
    Statement st = null;
    ResultSet rs = null;
    public Users identificar(Users user) throws Exception{
        String query = "select u.idusers, g.nombre_grupo from users u "
                + "inner join grupos g on u.id_grupo = g.id_grupo "
                + "where u.estado = '1' and u.username = '"+ user.getUsername() +"' and u.password = '"+ user.getPassword() +"';";
        con = new conexion_bd();
        
        try{
            cn = con.abrir_conexion_bd();
            st = cn.createStatement();
            rs = st.executeQuery(query);
            if(rs.next() == true){
                use = new Users();
                use.setIdusers(rs.getInt("idusers"));
                use.setUsername(user.getUsername());
                use.setGrupos(new grupos());
                use.getGrupos().setNombre_grupo(rs.getString("nombre_grupo"));
                use.setEstado(true);
            }
        }catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }finally{
            if(rs!=null && rs.isClosed() == false){
                rs.close();
            }
            rs = null;
            if(st!=null && st.isClosed() == false){
                st.close();
            }
            st = null;
            if(cn!=null & cn.isClosed() == false){
                cn.close();
            }
            cn = null;
        }
        return use;
    }
    
}







    /*public Connection conexionBD;
    conexion_bd cn = new conexion_bd();
    PreparedStatement parametro;
    ResultSet result;
    int r=0;
    @Override
    public int validar(Users user) {
        String sql = "select * from usuarios where username=? and password=?";
        try{
            conexionBD = cn.abrir_conexion_bd();
            parametro = conexionBD.prepareStatement(sql);
            parametro.setString(1, user.getUsername());
            parametro.setString(2, user.getPassword());
            result = parametro.executeQuery();
            
            while(result.next()){
                r=r+1;
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
            }
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        }catch(Exception e){
            return 0;
        }
    }
}*/
