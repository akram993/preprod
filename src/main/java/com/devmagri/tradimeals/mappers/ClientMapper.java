package com.devmagri.tradimeals.mappers;

import com.devmagri.tradimeals.dtos.ClientDTO;
import com.devmagri.tradimeals.entities.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {
    public Client fromClientDTO(ClientDTO clientDTO){
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        return client;
    }

    public ClientDTO fromClient(Client client){
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        clientDTO.setId(clientDTO.getId());
        return clientDTO;
    }

}
