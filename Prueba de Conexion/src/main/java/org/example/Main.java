package org.example;

import java.math.BigDecimal;
import java.sql.*;

public class Main {
    private static Connection myCon = null;
    private static Statement mystamt1 = null;
    private static PreparedStatement myStamt = null;
    private static ResultSet myRes = null;
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicio","root","");
            System.out.println("Genial, nos conectamos.");

            createProduct("Laive leche deslactosada 395gr", BigDecimal.valueOf(4.20));

            showColum("name");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Algo salio mal.");
        }
    }
    public static void createProduct(String name, BigDecimal price_sale) throws SQLException {
        String sql = ("INSERT INTO product (name, price_sale) VALUES (?, ?)");
        myStamt = myCon.prepareStatement(sql);
        myStamt.setString(1,name);
        myStamt.setBigDecimal(2, price_sale);
        int rowsAffected = myStamt.executeUpdate();

        if (rowsAffected > 0){
            System.out.println("Se ha creado un nuevo producto.");
        }
    }

    public static void showColum(String colum) throws SQLException {
        mystamt1 = myCon.createStatement();
        myRes = mystamt1.executeQuery("SELECT  * FROM product");
        while (myRes.next()){
            System.out.println(myRes.getString(colum));
        }
    }
}