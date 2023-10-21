package org.example;

import java.sql.*;

public class Main {
    private static Statement mystamt1 = null;
    private static PreparedStatement myStamt = null;
    private static ResultSet myRes = null;
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ejercicio";
        String user = "root";
        String pass = "";
        //Con el Try con recursos se cierra la conexión.
        try(Connection myCon = DriverManager.getConnection(url,user,pass)) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Genial, nos conectamos.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Algo salio mal.");
        }

    }
}