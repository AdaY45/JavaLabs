package production.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import production.pojo.people.Client;
import production.service.ClientService;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private ClientService clientService;

    @GetMapping("/id")
    Client findClientById(@RequestParam(name = "id") Long id) {
        return clientService.findClientById(id);
    }

    @GetMapping
    List<Client> findAll() {
        return clientService.findAll();
    }
}
