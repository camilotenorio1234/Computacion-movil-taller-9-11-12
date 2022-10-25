package com.usc.crud.service;

import com.usc.crud.model.Client;
import com.usc.crud.repository.Client_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class client_service {


    @Autowired
    private Client_repository repository2;

    public Optional<Client> finByClient(Client client){

        return repository2.findById(client.getId());

    }
    public Client guardarClient(Client client){

        return repository2.save (client);

    }
    public List<Client> buscarTdoso_client(){

        return (List<Client>) repository2.findAll();

    }
    public String  eliminarclient(Long id){

        String msj = "";
        Optional<Client> userDb = repository2.findById (id);
        if(!userDb.isEmpty()){
            repository2.delete(userDb.get());
            msj = "Paciente eliminado correctamente";
        }
        else{
            msj = "Paciente no encontradpo";
        }

        return msj;
    }
}
