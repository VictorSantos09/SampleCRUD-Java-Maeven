package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DbConnection {
    private Connection Connection;
    private final String Driver = "com.mysql.cj.jdbc.Driver";
    private final String Url = "jdbc:mysql://localhost:3306/mydb";

    protected Connection Connect() {
        try {
            Class.forName(Driver);
            Connection = DriverManager.getConnection(Url, "root",
                    "root");

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return Connection;
    }

    protected void Disconnect() {
        try {
            Connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}