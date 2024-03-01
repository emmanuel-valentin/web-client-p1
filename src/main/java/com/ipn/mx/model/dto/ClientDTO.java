package com.ipn.mx.model.dto;

import com.ipn.mx.model.entities.Client;
import lombok.Data;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author emma
 */

@Data
public class ClientDTO {
    private Client entity;
    
    public ClientDTO() {
        this.entity = new Client();
    }
}
