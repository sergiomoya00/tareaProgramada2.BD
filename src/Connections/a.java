/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jabre
 */
public class a {
    Conexion conexiona = new Conexion();
    Connection cina = conexiona.getConnection();
    PreparedStatement pst;
    public String idDistrito(String id){
    java.sql.Connection conectar=null;
    String S="SELECT idDistrito FROM distrito where distrito='"+id+"'";
    String b="";
      try{
     pst= cina.prepareCall(S);
    ResultSet result= pst.executeQuery();
    while(result.next()){
    b=result.getString("idDistrito");
    }
    
    
} catch(Exception e){
    System.out.print("error");
}
  finally{
    if(conectar!=null){
    try{
    conectar.close();
    }catch(SQLException ex){}
    }
    }
   return b;
  
   }
}
