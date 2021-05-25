package production.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import production.kpi.pojo.people.Client;
import production.kpi.service.ClientService;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    public Client findClientById(int id) {
        return clientService.getClientById(id);
    }

    public List<Client> findAll() {
        return clientService.findAll();
    }

    public Client save(Client client) {
        return clientService.save(client);
    }

    public Client update(Client client) {
        return clientService.updateClient(client);
    }

    public boolean delete(Integer clientId) {
        return clientService.deleteClient(clientId);
    }

    public Client findClientByLastname(String filterText) {
        return clientService.findClientByFullName(filterText);
    }
}
