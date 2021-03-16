package com.plane.service;

import com.plane.pojo.people.Client;
import com.plane.pojo.people.Worker;

import java.util.List;

public interface ClientService {
    public Client getClient(long id);
    public void createClient(Client client);
    public List<Client> getAllClients();
    public void updateClient(Client сlient);
    public void deleteClient(Client сlient);
}
