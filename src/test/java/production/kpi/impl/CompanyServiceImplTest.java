package production.kpi.impl;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import production.kpi.pojo.people.Worker;
import production.kpi.pojo.plane.Company;
import production.kpi.pojo.plane.Navy;
import production.kpi.repository.CompanyRepository;
import production.kpi.service.impl.CompanyServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceImplTest {
    @Mock
    private CompanyRepository companyRepository;
    @InjectMocks
    private CompanyServiceImpl companyService;
    private Company company;
    private List<Company> companies;
    private Navy plane;
    private Worker worker;
    private List<Worker> workers;
    private List<Navy> planes;

    @BeforeEach
    public void setUp() {
        company = new Company();
        companies = new ArrayList<>();
        companies.add(company);
        plane = new Navy();
        worker = new Worker();
        planes = new ArrayList<>();
        workers = new ArrayList<>();
        planes.add(plane);
        company.setPlanes(planes);
        workers.add(worker);
        company.setWorkers(workers);
    }

    @Test
    public void findCompanyById() {
        company = new Company();
        when(companyRepository.findById(1)).thenReturn(Optional.of(company));
        assertEquals(company, companyService.findCompanyById(1));
        verify(companyRepository).findById(1);
    }

    @Test
    public void save() {
        when(companyRepository.save(company)).thenReturn(company);
        assertEquals(company, companyService.save(company));
        verify(companyRepository).save(company);
    }

    @Test
    public void findAll() {
        when(companyRepository.findAll()).thenReturn(companies);
        assertEquals(companies, companyService.findAll());
        verify(companyRepository).findAll();
    }

    @Test
    public void findAllPlanesOfCompany() {
        company = new Company();
        when(companyRepository.findById(1)).thenReturn(Optional.of(company));
        assertEquals(planes, companyService.findAllPlanesOfCompany(1));
        verify(companyRepository).findById(1);
    }

    @Test
    public void findAllWorkersOfCompany() {
        company = new Company();
        when(companyRepository.findById(1)).thenReturn(Optional.of(company));
        assertEquals(workers, companyService.findAllWorkersOfCompany(1));
        verify(companyRepository).findById(1);
    }
}