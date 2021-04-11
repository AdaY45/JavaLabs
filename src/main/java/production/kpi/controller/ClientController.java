package production.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import production.kpi.pojo.people.Client;
import production.kpi.service.ClientService;

import java.util.List;

@Controller
/*@RestController
@RequestMapping("/clients")*/
public class ClientController {

    @Autowired
    private ClientService clientService;

    //    @GetMapping("/id")
    public Client findClientById(int id) {
        return clientService.getClientById(id);
    }

    //    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }

    public Client save(Client client) {
        return clientService.save(client);
    }
}
