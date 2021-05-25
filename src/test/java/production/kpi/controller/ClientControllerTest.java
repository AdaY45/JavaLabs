package production.kpi.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import production.kpi.KpiApplication;
import production.kpi.pojo.people.Client;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KpiApplication.class)
public class ClientControllerTest {
    @Autowired
    private ClientController clientController;
    private List<Client> clients;
    private Integer clientId = null;

    @Before
    public void setUp() {
        clients = clientController.findAll();
    }


    @Test
    public void findClientById() {
        Client expected = new Client("Zarichniy", "Oleg", "dfgdfg@gmail.com",
                "fdgdgfgd");
        Client actual = clientController.findClientById(1);
        assertEquals(expected, actual);
    }

    @Test
    public void findAll() {
        List<Client> expected = new ArrayList<>();
        List<Client> clients = clientController.findAll();
        Client client = new Client("Zarichniy", "Oleg", "dfgdfg@gmail.com", "fdgdgfgd");
        Client client2 = new Client("Bogdanets", "Olexandr", "bogolex@gmail.com",
                "bog12345");
        Client client3 = new Client("Kochyba", "Olga", "koch34@gmail.com", "123456");
        expected.add(client);
        expected.add(client2);
        expected.add(client3);
        assertEquals(expected, clients);
    }

    @Test
    public void save() {
        Client client1 = new Client("Zarichniy", "Oleg", "dfgdfg@gmail.com",
                "fdgdgfgd");
        Client actual1 = clientController.save(client1);
        List<Client> actual = clientController.findAll();
        clientId = actual.get(actual.size() - 1).getId();
        clients.get(clients.size() - 1).setId(clientId);
        client1.setId(clientId);
        assertEquals(client1, actual1);
    }

    @After
    public void tearDown() {
        if (clientId != null) {
            clientController.delete(clientId);
        }
    }
}