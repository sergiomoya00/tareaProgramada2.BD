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
public class Notafinal {

    Conexion p = new Conexion();
    static double nota = 0;
    String b = "";

    public double ObtenerNotaFinal(String id) {
        java.sql.Connection conectar = null;
        String SSQL = "SELECT a.notaAsignada,b.valorPorcentual FROM notas a,calendarioevaluacion b,practicante c where c.idPracticante=a.idPracticante AND a.idCalendario=b.idCalendario AND c.idPracticante=" + id;
        try {
            conectar = p.getConnection();
            PreparedStatement pst = conectar.prepareCall(SSQL);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                if (Integer.parseInt(result.getString("valorPorcentual")) <= 9) {
                    b = "0.0" + result.getString("valorPorcentual");
                }
                if (Integer.parseInt(result.getString("valorPorcentual")) > 9) {
                    b = "0." + result.getString("valorPorcentual");
                }
                double numero = Double.parseDouble(b);
                double porcentaje = numero * result.getInt("notaAsignada");
                nota = nota + porcentaje;
            }

        } catch (Exception e) {

        } finally {
            if (conectar != null) {
                try {
                    conectar.close();
                } catch (SQLException ex) {
                }
            }
        }

        return nota;
    }
}
