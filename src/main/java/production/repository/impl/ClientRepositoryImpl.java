package production.repository.impl;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import production.pojo.people.Client;
import production.repository.ClientRepository;

import java.util.List;

@Repository
public class ClientRepositoryImpl {
    public Client findClientById(long id) {
        throw new NotImplementedException("TODO");
    }

    public Client updateClient(Client client) {
        throw new NotImplementedException("TODO");
    }

    public boolean deleteClient(Integer id) {return false;}

    public Client save(Client client) {
        throw new NotImplementedException("TODO");
    }

    public List<Client> findAll() {
        throw new NotImplementedException("TODO");
    }
}
