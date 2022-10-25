package com.usc.crud.controller;

import com.usc.crud.model.Client;

import com.usc.crud.service.client_service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class Client_controller {


    @Autowired
    private client_service service2;


    @GetMapping("/consultar_client/{id}")
    public ResponseEntity<?> filtrar(@PathParam("id") Client client){

        return ResponseEntity.ok(service2.finByClient(client));
    }
    // create employee rest api
    @PostMapping("/guardar_client")
    public Client createClient(@RequestBody Client client) {
        return service2.guardarClient(client);
    }

    @GetMapping("/consultarAll_client")
    public ResponseEntity<?> consultarByUser_client(){

        return ResponseEntity.ok(service2.buscarTdoso_client()
        );
    }

    // update employee rest api



    // delete employee rest api
    @DeleteMapping("/delete_client/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id){
        String msj = service2.eliminarclient(id);
        return ResponseEntity.ok(msj);
    }
}
