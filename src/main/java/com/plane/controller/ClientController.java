package com.plane.controller;

import com.plane.exception.WorkerNotFoundException;
import com.plane.pojo.people.Client;
import com.plane.pojo.people.Worker;
import com.plane.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class ClientController {

    private ClientService clientService;

    public void createClient(Client client) {
        clientService.createClient(client);
    }

    public Client getClientById(Integer id) throws NoSuchElementException {
        Client client = clientService.getClient(id);
        if(client == null) {
            throw new NoSuchElementException("There is no such client with given id.");
        }
        return client;
    }

    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    public void updateClient(Client client) {
        clientService.updateClient(client);
    }

    public void deleteClient(Client client) {
        clientService.deleteClient(client);
    }
}
