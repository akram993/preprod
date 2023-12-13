package com.devmagri.tradimeals.services;

import com.devmagri.tradimeals.dtos.ClientDTO;
import com.devmagri.tradimeals.entities.Client;

import java.util.List;

public interface ClientService {
    ClientDTO saveClient(ClientDTO clientDTO);
    List<ClientDTO> getClients();
}
