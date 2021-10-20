/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author E7440
 */
public class validar_conexion {
    public static void main(String[] args){
        conexion_bd cn = new conexion_bd();
        if(cn.abrir_conexion_bd()!=null){
            System.out.println("Si funciono!");
        }else{
            System.out.println("no funciono T-T");
        }
    }
}
