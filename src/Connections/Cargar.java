/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author jabre
 */
public class Cargar {

    Conexion p = new Conexion();

    public void Cargardistritos(JComboBox combo) {
        java.sql.Connection conectar = null;
        String SSQL = "SELECT distrito FROM distrito ORDER BY distrito ASC ";
        try {
            conectar = p.getConnection();
            PreparedStatement pst = conectar.prepareCall(SSQL);
            ResultSet result = pst.executeQuery();
            combo.addItem("Distritos");
            while (result.next()) {
                combo.addItem(result.getString("distrito"));
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
    }

    public void CargarCalendarios(JComboBox combo) {
        java.sql.Connection conectar = null;
        String SSQL = "SELECT idCalendario, detalle FROM calendarioevaluacion ORDER BY idCalendario ASC ";
        try {
            conectar = p.getConnection();
            PreparedStatement pst = conectar.prepareCall(SSQL);
            ResultSet result = pst.executeQuery();
            combo.addItem("Evaluación");
            while (result.next()) {
                combo.addItem(result.getString("detalle") + " - " + result.getString("idCalendario"));
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
    }

    public void CargarPeriodo(JComboBox combo) {
        java.sql.Connection conectar = null;
        String SSQL = "SELECT año, numeroSemestre FROM periodopractica";
        try {
            conectar = p.getConnection();
            PreparedStatement pst = conectar.prepareCall(SSQL);
            ResultSet result = pst.executeQuery();
            combo.addItem("Evaluación");
            while (result.next()) {
                combo.addItem("Número de semestre: " + result.getString("numeroSemestre") + 
                        " - " + result.getString("año"));
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
    }

        public void CargarEstudiantes2(JComboBox combo) {
        java.sql.Connection conectar = null;
        String SSQL = "SELECT primerNombre, segundoNombre, primerApellido, segundoApellido FROM practicante ";
        try {
            conectar = p.getConnection();
            PreparedStatement pst = conectar.prepareCall(SSQL);
            ResultSet result = pst.executeQuery();
            combo.addItem("Estudiante");
            while (result.next()) {
                combo.addItem(result.getString("primerNombre") + " "
                        + result.getString("segundoNombre") + " " + result.getString("primerApellido")
                        + " " + result.getString("segundoApellido"));
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
    }
    
    public void CargarEstudiantes(JComboBox combo) {
        java.sql.Connection conectar = null;
        String SSQL = "SELECT primerNombre, segundoNombre, primerApellido, segundoApellido,idPracticante FROM practicante ORDER BY idPracticante ASC ";
        try {
            conectar = p.getConnection();
            PreparedStatement pst = conectar.prepareCall(SSQL);
            ResultSet result = pst.executeQuery();
            combo.addItem("Estudiante");
            while (result.next()) {
                combo.addItem(result.getString("primerNombre") + " "
                        + result.getString("segundoNombre") + " " + result.getString("primerApellido")
                        + " " + result.getString("segundoApellido") + " - Carnet: " + result.getString("idPracticante"));
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
    }

    public ByteArrayInputStream savePhoto(Image img) throws IOException {

        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();

        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "png", baos);
        } finally {
            try {
                baos.close();
            } catch (Exception e) {
            }
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

        PreparedStatement stmt = null;

        return bais;
    }

    public byte[] convertFileContentToBlob(String filePath) throws IOException {
        byte[] fileContent = null;
        // initialize string buffer to hold contents of file
        StringBuffer fileContentStr = new StringBuffer("");
        BufferedReader reader = null;
        try {
            // initialize buffered reader  
            reader = new BufferedReader(new FileReader(filePath));
            String line = null;
            // read lines of file
            while ((line = reader.readLine()) != null) {
                //append line to string buffer
                fileContentStr.append(line).append("\n");
            }
            // convert string to byte array
            fileContent = fileContentStr.toString().trim().getBytes();
        } catch (IOException e) {
            throw new IOException("Unable to convert file to byte array. "
                    + e.getMessage());
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return fileContent;
    }

}
