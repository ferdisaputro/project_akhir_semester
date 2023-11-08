/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myTech;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class Koneksi {

    static Object GetConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    Connection conn;
    public Koneksi(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/penjualan","root","");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "koneksi Database Gagal !"+e);
        }
    }
    Connection GetConnection(){
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
           conn = DriverManager.getConnection("jdbc:mysql://localhost/penjualan","root","");
        } catch (Exception e){
        }
        return conn;
    }
}