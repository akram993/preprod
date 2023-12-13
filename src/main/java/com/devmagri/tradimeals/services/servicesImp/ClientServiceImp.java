package com.devmagri.tradimeals.services.servicesImp;

import com.devmagri.tradimeals.controllers.ClientController;
import com.devmagri.tradimeals.dtos.ClientDTO;
import com.devmagri.tradimeals.entities.Client;
import com.devmagri.tradimeals.entities.UserProfile;
import com.devmagri.tradimeals.mappers.ClientMapper;
import com.devmagri.tradimeals.repositories.ClientRepository;
import com.devmagri.tradimeals.services.ClientService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ClientServiceImp implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

    public ClientDTO saveClient(ClientDTO clientDTO){
        log.info("saving new client");
        Client client = clientMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return clientMapper.fromClient(savedClient);
    }

    @Override
    public List<ClientDTO> getClients() {
        log.info("listing all clients");
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> clientDTOs = clients.stream().
                map(client -> clientMapper.fromClient(client)).
                collect(Collectors.toList());
        return clientDTOs;
    }
}
