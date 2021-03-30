package production.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.pojo.people.Client;
import production.repository.ClientRepository;
import production.service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client findClientById(long id) {
        return clientRepository.findClientById(id);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.updateClient(client);
    }

    @Override
    public boolean deleteClient(Integer id) {
        return clientRepository.deleteClient(id);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
