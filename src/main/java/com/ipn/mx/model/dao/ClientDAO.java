/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.model.dao;

import com.ipn.mx.model.dto.ClientDTO;
import com.ipn.mx.model.entities.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emma
 */
public class ClientDAO {

    private static final String SQL__INSERT = "INSERT INTO Client (nombre, paterno, materno, email) VALUES (?, ?, ?, ?)";
    private static final String SQL__UPDATE = "UPDATE Client SET nombre = ?, paterno = ?, materno = ?, email = ? WHERE id = ?";
    private static final String SQL__DELETE = "DELETE FROM Client WHERE id = ?";
    private static final String SQL__SELECT_ALL = "SELECT * FROM Client";
    private static final String SQL__SELECT = "SELECT * FROM Client WHERE id = ?";
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
            ps = conn.prepareStatement(SQL__INSERT);
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

    public void update(ClientDTO clientDTO) throws SQLException {
        getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL__UPDATE);
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

    public void delete(int id) throws SQLException {
        getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL__DELETE);
            ps.setInt(1, id);
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

    public List<Client> get() throws SQLException {
        getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List clients = new ArrayList<Client>();

        try {
            ps = conn.prepareStatement(SQL__SELECT_ALL);

            if (ps.execute()) {
                rs = ps.getResultSet();
            }

            while (rs.next()) {
                Client clientResult = new Client();
                clientResult.setId(rs.getInt(1));
                clientResult.setNombre(rs.getString(2));
                clientResult.setNombre(rs.getString(3));
                clientResult.setNombre(rs.getString(4));
                clientResult.setNombre(rs.getString(5));

                clients.add(clientResult);
            }

        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return clients;
    }

    public Client getById(int id) throws SQLException {
        getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Client clientResult = null;

        try {
            ps = conn.prepareStatement(SQL__SELECT);
            ps.setInt(0, id);

            if (ps.execute()) {
                rs = ps.getResultSet();
            }

            clientResult.setId(rs.getInt(1));
            clientResult.setNombre(rs.getString(2));
            clientResult.setNombre(rs.getString(3));
            clientResult.setNombre(rs.getString(4));
            clientResult.setNombre(rs.getString(5));

        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return clientResult;
    }
}
