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
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author jabre
 */
public class Cargar{
    Conexion p= new Conexion();
    Conexion s=new Conexion();
    public void Cargardistritos(JComboBox combo){
    java.sql.Connection conectar=null;
    String SSQL="SELECT distrito FROM distrito ORDER BY distrito ASC ";
    try{
    conectar=p.getConnection();
    PreparedStatement pst= conectar.prepareCall(SSQL);
    ResultSet result= pst.executeQuery();
    combo.addItem("Distritos");
    while(result.next()){
    combo.addItem(result.getString("distrito"));
    }
    while(result.next()){
    combo.addItem(result.getString("idProfesor"));
    }
    
    
} catch(Exception e){

}finally{
    if(conectar!=null){
    try{
    conectar.close();
    }catch(SQLException ex){}
    }
    }
    }
    public void CargarPracticante(JComboBox combo){
    java.sql.Connection conectar=null;
    String SSQL="SELECT idPracticante FROM practicante ORDER BY idPracticante ASC ";
    try{
    conectar=p.getConnection();
    PreparedStatement pst= conectar.prepareCall(SSQL);
    ResultSet result= pst.executeQuery();
    while(result.next()){
    combo.addItem(result.getString("idpracticante"));
    }
    
    
} catch(Exception e){

}finally{
    if(conectar!=null){
    try{
    conectar.close();
    }catch(SQLException ex){}
    }
    }
    }
    
    
    public void CargarProfesor(JComboBox combo){
    java.sql.Connection conectar=null;
    String SSQL="SELECT idProfesor FROM profesor ORDER BY idProfesor ASC ";
    try{
    conectar=s.getConnection();
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
        public void CargarAnno(JComboBox combo){
    java.sql.Connection conectar=null;
    String SSQL="SELECT año FROM periodopractica ORDER BY año ASC ";
    try{
    conectar=p.getConnection();
    PreparedStatement pst= conectar.prepareCall(SSQL);
    ResultSet result= pst.executeQuery();
    while(result.next()){
    combo.addItem(result.getString("año"));
    }
    
    
} catch(Exception e){

}finally{
    if(conectar!=null){
    try{
    conectar.close();
    }catch(SQLException ex){}
    }
    }
    }
              public void CargarSupervisor(JComboBox combo){
    java.sql.Connection conectar=null;
    String SSQL="SELECT idSupervisor FROM supervisor ORDER BY idSupervisor ASC ";
    try{
    conectar=p.getConnection();
    PreparedStatement pst= conectar.prepareCall(SSQL);
    ResultSet result= pst.executeQuery();
    while(result.next()){
    combo.addItem(result.getString("idSupervisor"));
    }
    
    
} catch(Exception e){

}finally{
    if(conectar!=null){
    try{
    conectar.close();
    }catch(SQLException ex){}
    }
    }
    }
                  public void CargareEmpresa(JComboBox combo){
    java.sql.Connection conectar=null;
    String SSQL="SELECT idEmpresa FROM empresa ORDER BY idEmpresa ASC ";
    try{
    conectar=p.getConnection();
    PreparedStatement pst= conectar.prepareCall(SSQL);
    ResultSet result= pst.executeQuery();
    while(result.next()){
    combo.addItem(result.getString("idEmpresa"));
    }
    
    
} catch(Exception e){

}finally{
    if(conectar!=null){
    try{
    conectar.close();
    }catch(SQLException ex){}
    }
    }
    }
}
