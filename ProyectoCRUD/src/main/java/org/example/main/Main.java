package org.example.main;

import org.example.util.DatabaseConnection;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        try(Connection myCon = DatabaseConnection.getInstance()) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Genial, nos conectamos.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Algo salio mal.");
        }

    }
}