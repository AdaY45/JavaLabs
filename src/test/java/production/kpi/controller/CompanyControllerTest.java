package production.kpi.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import production.kpi.KpiApplication;
import production.kpi.pojo.people.Worker;
import production.kpi.pojo.plane.Company;
import production.kpi.pojo.plane.Navy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KpiApplication.class)
public class CompanyControllerTest {
    @Autowired
    private CompanyController companyController;
    private List<Company> companies;
    private Integer companyId = null;

    @Before
    public void setUp() {
        companies = companyController.findAll();
    }

    @Test
    public void findAll() {
        List<Company> expected = new ArrayList<>();
        Navy plane = new Navy(1, "F/A-18E/F Super Hornet", "In service", "US$66.0 million", 1915D);
        Navy plane2 = new Navy(2, "E-2 Hawkeye", "In service", "US$176 million", 650D);
        Navy plane3 = new Navy(3, "P-8 Poseidon", "In service", "US$256.5 million", 907D);
        Navy plane4 = new Navy(4, "EA-18G Growler", "In service", "US$68.2 million", 1900D);
        Navy plane5 = new Navy(5, "E-6 Mercury", "In service", "US$141.7 million", 980D);
        Navy plane6 = new Navy(6, "P-8 Poseidon", "In service", "US$256.5 million", 907D);
        Navy plane7 = new Navy(7, "F/A-18E/F Super Hornet", "In service", "US$66.0 million", 1915D);
        Navy plane8 = new Navy(8, "E-2 Hawkeye", "In service", "US$176 million", 650D);
        Navy plane9 = new Navy(9, "E-6 Mercury", "In service", "US$141.7 million", 980D);
        Navy plane10 = new Navy(10,"EP-3", "Active", "US$36 million", 700D);

        List<Navy> planes = List.of(plane, plane2, plane3, plane4, plane5, plane6, plane7, plane8, plane9, plane10);

        Worker worker1 = new Worker(1, "Zalizniy", "Dmytro", "Mechanic",
                "zaldm@gmail.com", "Zal1123456");
        Worker worker2 = new Worker(2, "Golyb", "Olga", "Technician",
                "tech@gmail.com", "123456");
        List<Worker> workers = List.of(worker1, worker2);
        Company company = new Company("Boeing", 9D, planes, workers);
        expected.add(company);
        List<Company> companies = companyController.findAll();
        Assertions.assertEquals(expected, companies);
    }

    @Test
    public void save() {
        Company expected = new Company("Kinder", 45657D);
        Company actual1 = companyController.save(expected);
        List<Company> companies = companyController.findAll();
        companyId = companies.get(companies.size() - 1).getId();
        companies.get(companies.size() - 1).setId(companyId);
        expected.setId(companyId);
        assertEquals(expected, actual1);
    }

    @After
    public void tearDown() {
        if (companyId != null) {
            companyController.deleteById(companyId);
        }
    }

}
