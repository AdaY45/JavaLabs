package production.kpi.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import production.kpi.pojo.people.Client;
import production.kpi.repository.ClientRepository;
import production.kpi.service.impl.ClientServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {
    @Mock
    private ClientRepository clientRepository;
    @InjectMocks
    private ClientServiceImpl clientService;
    private Client client;
    private List<Client> clients;

    @Before
    public void setUp() {
        client = new Client();
        client.setFirstName("Dan");
        client.setId(1);
        clients = new ArrayList<>();
        clients.add(client);
    }

    @Test
    public void getClientById() {
        when(clientRepository.findById(1)).thenReturn(Optional.ofNullable(client));
        assertEquals(client, clientService.getClientById(1));
        verify(clientRepository).findById(1);
    }

    @Test
    public void save() {
        when(clientRepository.save(client)).thenReturn(client);
        assertEquals(client, clientService.save(client));
        verify(clientRepository).save(client);

    }

    @Test
    public void findAll() {
        when(clientRepository.findAll()).thenReturn(clients);
        assertEquals(clients, clientService.findAll());
        verify(clientRepository).findAll();
    }
}