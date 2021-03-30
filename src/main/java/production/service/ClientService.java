package production.service;

import production.pojo.people.Client;

import java.util.List;

public interface ClientService {
    Client findClientById(long id);

    Client updateClient(Client client);

    boolean deleteClient(Integer id);

    Client save(Client client);

    List<Client> findAll();
}
