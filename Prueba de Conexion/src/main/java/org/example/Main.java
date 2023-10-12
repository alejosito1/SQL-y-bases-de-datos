package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection myCon = null;
        Statement myStamt = null;
        ResultSet myRes = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio","root","");
            System.out.println("Genial, nos conectamos.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Algo salio mal.");
        }
    }
}