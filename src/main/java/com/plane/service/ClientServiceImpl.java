package com.plane.service;

import com.plane.pojo.people.Client;
import com.plane.pojo.people.Worker;
import com.plane.repository.ClientRepository;
import com.plane.repository.WorkerRepository;

import java.util.Collections;
import java.util.List;

public class ClientServiceImpl implements ClientService{
    private ClientRepository clientRepository;

    @Override
    public Client getClient(long id) {
        return clientRepository.findClientById(id);
    }

    @Override
    public void createClient(Client client) {
        clientRepository.createClient(client);
    }

    @Override
    public List<Client> getAllClients() {
        return Collections.emptyList();
    }

    @Override
    public void updateClient(Client client) {
        clientRepository.updateClient(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.deleteClient(client);
    }
}
