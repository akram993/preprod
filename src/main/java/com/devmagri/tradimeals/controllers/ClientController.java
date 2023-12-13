package com.devmagri.tradimeals.controllers;

import com.devmagri.tradimeals.dtos.ClientDTO;
import com.devmagri.tradimeals.entities.Client;
import com.devmagri.tradimeals.repositories.ClientRepository;
import com.devmagri.tradimeals.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/client")
    public void saveClient(@RequestBody ClientDTO clientDTO){
        clientService.saveClient(clientDTO);
    }

    @GetMapping("clients")
    public List<ClientDTO> getClients(){
        return clientService.getClients();
    }
}
