/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.model.entities;

import com.ipn.mx.model.dto.ClientDTO;

import java.sql.SQLException;

import com.ipn.mx.model.dao.ClientDAO;

/**
 *
 * @author emma
 */
public class Client {
    private int id;
    private String nombre;
    private String paterno;
    private String materno;
    private String email;

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{ id: " + this.id + "\nnombre: " + this.nombre + "\npaterno: " + this.paterno + "\nmaterno: "
                + this.materno + "\nemail: " + this.email + "\n}";
    }

    public static void main(String[] args) throws SQLException {
        ClientDTO DTO = new ClientDTO();
        DTO.getEntity().setId(8);
        // DTO.getEntity().setNombre("Peter");
        // DTO.getEntity().setPaterno("Parker");
        // DTO.getEntity().setMaterno("Spiderman");
        // DTO.getEntity().setEmail("spidy@avengers.com");

        ClientDAO DAO = new ClientDAO();
        // DAO.create(DTO);
        // DAO.update(DTO);
        // DAO.delete(DTO);

    }
}
