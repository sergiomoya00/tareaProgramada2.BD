/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada1.bases.gui;

import Connections.Conexion;
import Connections.EmailNotification;
import Connections.ObtenerCorreos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jabre
 */
public class RegisterStudentperiod extends javax.swing.JFrame {
    Conexion conexion = new Conexion();
    Connection cin = conexion.getConnection();
    PreparedStatement ps;
     EmailNotification k=new EmailNotification();
     ObtenerCorreos co=new ObtenerCorreos();
    /**
     * Creates new form RegisterStudentperiod
     */
    public RegisterStudentperiod() {
        initComponents();
        Carga();
        
        
        
    }

        void Registerperiodo() {
    
        String insertar = "insert into periodopracticante (idPracticante,idProfesor,año,numeroSemestre,idSupervisor,idEncargado,idEmpresa) values (?,?,?,?,?,?,?) ";
        
        
        try {
            RegisterStudent p=new RegisterStudent();
            ps = cin.prepareCall(insertar);
            ps.setInt(1,Integer.parseInt(comboestudiante.getSelectedItem().toString()));
            ps.setInt(2, Integer.parseInt(comboprofesor.getSelectedItem().toString()));
            ps.setInt(3,Integer.parseInt(comboaño.getSelectedItem().toString()) );
            ps.setInt(4,Integer.parseInt(combosemestre.getSelectedItem().toString()));
            ps.setInt(5, Integer.parseInt(combosupervisor.getSelectedItem().toString()));
            ps.setInt(6, Integer.parseInt(comboencargado.getSelectedItem().toString()));
            ps.setInt(7, Integer.parseInt(comboempresa.getSelectedItem().toString()));
           

            int registro = ps.executeUpdate();
            if (registro > 0) {
                JOptionPane.showMessageDialog(this, "Usuario registrado con exito", "Bien", JOptionPane.QUESTION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no registrado con exito", "atencion", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {

        }
    }
        void Carga(){
    java.sql.Connection conectar=null;
    String SSQL="SELECT idEmpresa FROM empresa";
    try{
    
    ps= cin.prepareCall(SSQL);
    ResultSet result= ps.executeQuery();
    while(result.next()){
        comboempresa.addItem(result.getString("idEmpresa"));
    }
    
    
} catch(Exception e){
    System.out.print("error");
}
      
      
    String SSQ="SELECT idEncargado FROM encargadopractica";
    try{
    
    ps= cin.prepareCall(SSQ);
    ResultSet result= ps.executeQuery();
    while(result.next()){
        comboencargado.addItem(result.getString("idEncargado"));
    }
    
    
} catch(Exception e){
    System.out.print("error");
}
     
    String SS="SELECT idSupervisor FROM supervisor";
    try{
    
    ps= cin.prepareCall(SS);
    ResultSet result= ps.executeQuery();
    while(result.next()){
        combosupervisor.addItem(result.getString("idSupervisor"));
    }
    
    
} catch(Exception e){
    System.out.print("error");
}
      
    String S="SELECT idProfesor FROM profesor";
    try{
    
    ps= cin.prepareCall(S);
    ResultSet result= ps.executeQuery();
    while(result.next()){
        comboprofesor.addItem(result.getString("idProfesor"));
    }
    
    
} catch(Exception e){
    System.out.print("error");
}
       String a="SELECT año FROM periodopractica";
    try{
    
    ps= cin.prepareCall(a);
    ResultSet result= ps.executeQuery();
    while(result.next()){
        comboaño.addItem(result.getString("año"));
    }
    
    
} catch(Exception e){
    System.out.print("error");
}
       String b="SELECT numeroSemestre FROM periodopractica";
    try{
    
    ps= cin.prepareCall(b);
    ResultSet result= ps.executeQuery();
    while(result.next()){
        combosemestre.addItem(result.getString("numeroSemestre"));
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
        }
        void correo(){
         String texto1="Estudiante asignado es:"+comboestudiante.getSelectedItem().toString()+"en el semestre"+combosemestre.getSelectedItem().toString()+"del año"+comboaño.getSelectedItem().toString();
    String texto2="Profesor asignado es:"+comboestudiante.getSelectedItem().toString()+"Supervisor asignado"+combosupervisor.getSelectedItem().toString()+"en el semestre"+combosemestre.getSelectedItem().toString()+"del año"+comboaño.getSelectedItem().toString();
    String correo1=co.ObtenerCorreoEstudiante(comboestudiante.getSelectedItem().toString());
    String correo2=co.ObtenerCorreoProfesor(comboprofesor.getSelectedItem().toString());
    String correo3=co.ObtenerCorreoSupervisor(combosupervisor.getSelectedItem().toString());
    System.out.print(correo1);
    System.out.print(correo2);
    System.out.print(correo3);
        k.sendEmail("jabrenega@gmail.com", "caca",jLabel1);
        k.sendEmail("jabrenega@gmail.com", "caca",jLabel1);
        k.sendEmail("jabrenega@gmail.com", "caca",jLabel1);
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboprofesor = new javax.swing.JComboBox<>();
        combosupervisor = new javax.swing.JComboBox<>();
        comboencargado = new javax.swing.JComboBox<>();
        comboempresa = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        comboaño = new javax.swing.JComboBox<>();
        combosemestre = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboestudiante = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Año");

        jLabel2.setText("Semestre");

        jLabel3.setText("Encargado de practica ");

        jLabel4.setText("Empresa");

        jLabel5.setText("Profesor");

        jLabel6.setText("Supervisor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(259, 259, 259)
                                .addComponent(jLabel1)
                                .addGap(113, 113, 113)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(326, 326, 326)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(comboaño, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(combosemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboencargado, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel3)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addComponent(comboempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(142, 142, 142)
                                        .addComponent(jLabel4)))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboprofesor, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combosupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel5)
                        .addGap(192, 192, 192)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(comboestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(comboestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combosupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboprofesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboempresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboencargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combosemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Registerperiodo();
    correo();
    SupervisorFunctions g=new SupervisorFunctions();
    g.setVisible(true);
    this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterStudentperiod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterStudentperiod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterStudentperiod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterStudentperiod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterStudentperiod().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboaño;
    private javax.swing.JComboBox<String> comboempresa;
    private javax.swing.JComboBox<String> comboencargado;
    public javax.swing.JComboBox<String> comboestudiante;
    private javax.swing.JComboBox<String> comboprofesor;
    private javax.swing.JComboBox<String> combosemestre;
    private javax.swing.JComboBox<String> combosupervisor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
