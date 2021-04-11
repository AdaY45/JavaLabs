package production.kpi.service;

import production.kpi.pojo.people.Client;

import java.util.List;

public interface ClientService {
    Client getClientById(int id);

    Client updateClient(Client client);

    boolean deleteClient(Client client);

    Client save(Client client);

    List<Client> findAll();
}