/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author jabre
 */
public class ObtenerCorreos {
    Conexion p= new Conexion();
    public String ObtenerCorreoProfesor(String id){
    java.sql.Connection conectar=null;
    String b="";
    String SSQL="SELECT correoElectronico FROM profesor where id="+id;
    try{
    conectar=p.getConnection();
    PreparedStatement pst= conectar.prepareCall(SSQL);
    ResultSet result= pst.executeQuery();
    while(result.next()){
    b=result.getString("correoElectronico");
    }
    
    
} catch(Exception e){

}finally{
    if(conectar!=null){
    try{
    conectar.close();
    }catch(SQLException ex){}
    }
    }
    return b;    
}
     public String ObtenerCorreoSupervisor(String id){
    java.sql.Connection conectar=null;
    String b="";
    String SSQL="SELECT correoElectronico FROM supervisor where id="+id;
    try{
    conectar=p.getConnection();
    PreparedStatement pst= conectar.prepareCall(SSQL);
    ResultSet result= pst.executeQuery();
    while(result.next()){
    b=result.getString("correoElectronico");
    }
    
    
} catch(Exception e){

}finally{
    if(conectar!=null){
    try{
    conectar.close();
    }catch(SQLException ex){}
    }
    }
    return b;    
}
      public String ObtenerCorreoEstudiante(String id){
    java.sql.Connection conectar=null;
    String b="";
    String SSQL="SELECT correoElectronico FROM practicante where id="+id;
    try{
    conectar=p.getConnection();
    PreparedStatement pst= conectar.prepareCall(SSQL);
    ResultSet result= pst.executeQuery();
    while(result.next()){
    b=result.getString("correoElectronico");
    }
    
    
} catch(Exception e){

}finally{
    if(conectar!=null){
    try{
    conectar.close();
    }catch(SQLException ex){}
    }
    }
    return b;    
}

}
