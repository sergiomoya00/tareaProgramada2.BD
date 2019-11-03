/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author jabre
 */
public class metodossql {
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int reultado_numero=0;
    public  String buscarNombre(String correo){
    String busqueda_nombre=null;
    Conexion p=new Conexion();
    Connection co=null;
    try{
    co=p.getConnection();
    String sentencia_buscar=("SELECT primerNombre,segundoNombre,primerApellido,segundoApellido FROM encargadopractica where correoElectronico= '"+correo+"'");
    sentencia_preparada=co.prepareStatement(sentencia_buscar);
    resultado=sentencia_preparada.executeQuery();
    if(resultado.next()){
    String primerNombre=resultado.getString("primerNombre");
        String   segundoNombre=resultado.getString("segundoNombre");
        String   primerApellido=resultado.getString("primerApellido");
        String   segundoApellido=resultado.getString("segundoApellido");
        busqueda_nombre=(primerNombre+"  "+segundoNombre+"  "+primerApellido+"  "+segundoApellido);
    }
    co.close();
    }catch(Exception e){}
    return busqueda_nombre;
    }
    public  String buscarContraseñaRegistrada(String correo){
    Conexion a=new Conexion();
    String contraseña=null;
    Connection co=null;
    try{
    co=a.getConnection();
    String sentencia_buscar_usuario=("SELECT contraseña FROM usuarioencargado WHERE  correoElectronico= '"+correo+"'");
    sentencia_preparada=co.prepareStatement(sentencia_buscar_usuario);
    resultado=sentencia_preparada.executeQuery();
    if(resultado.next()){
    contraseña=resultado.getString("contraseña");
    }
    else{
    contraseña="usuario no encontrado";
    }
    co.close();
    }catch(Exception e){}
    return contraseña;
    }
    public  String buscarCorreoRegistrado(String correo){
    Conexion a=new Conexion();
    String busqueda_usuario=null;
    Connection co=null;
    try{
    co=a.getConnection();
    String sentencia_buscar_usuario=("SELECT correoElectronico FROM usuarioencargado WHERE  correoElectronico= '"+correo+"'");
    sentencia_preparada=co.prepareStatement(sentencia_buscar_usuario);
    resultado=sentencia_preparada.executeQuery();
    if(resultado.next()){
    busqueda_usuario="usuario encontrado";
    }
    else{
    busqueda_usuario="usuario no encontrado";
    }
    co.close();
    }catch(Exception e){}
    return busqueda_usuario;
    }
    
}
