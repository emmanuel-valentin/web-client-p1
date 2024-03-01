/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.model.dao;

import com.ipn.mx.model.dto.ClientDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emma
 */
public class ClientDAO {
    private final String SQL_INSERT = "INSERT INTO Client (nombre, paterno, materno, email) VALUES (?, ?, ?, ?)";
    private Connection conn;

    private void getConnection() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/demo242";
        String user = "root";
        String password = "";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create(ClientDTO clientDTO) throws SQLException {
        getConnection();
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, clientDTO.getEntity().getNombre());
            ps.setString(2, clientDTO.getEntity().getPaterno());
            ps.setString(3, clientDTO.getEntity().getMaterno());
            ps.setString(4, clientDTO.getEntity().getEmail());

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
