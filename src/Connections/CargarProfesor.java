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
public class CargarProfesor {
    Conexion p= new Conexion();
    public void CargarProfesor(JComboBox combo){
    java.sql.Connection conectar=null;
    String SSQL="SELECT idProfesor FROM profesor ORDER BY idProfesor ASC ";
    try{
    conectar=p.getConnection();
    PreparedStatement pst= conectar.prepareCall(SSQL);
    ResultSet result= pst.executeQuery();
    while(result.next()){
    combo.addItem(result.getString("idProfesor"));
    }
    
    
} catch(Exception e){
    System.out.print("error");
}finally{
    if(conectar!=null){
    try{
    conectar.close();
    }catch(SQLException ex){}
    }
    }
    }
}
