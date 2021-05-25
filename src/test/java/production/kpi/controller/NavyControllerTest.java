package production.kpi.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import production.kpi.KpiApplication;
import production.kpi.pojo.people.Client;
import production.kpi.pojo.plane.Navy;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KpiApplication.class)
public class NavyControllerTest {
    @Autowired
    private NavyController navyController;
    private List<Navy> navies;
    private Integer navyId;

    @Before
    public void setUp () {
        navies = navyController.findAll();
    }

    @Test
    public void findAll() {
        Navy plane = new Navy(1, "F/A-18E/F Super Hornet", "In service", "US$66.0 million",1915D);
        Navy plane2 = new Navy(2, "E-2 Hawkeye", "In service", "US$176 million", 650D);
        Navy plane3 = new Navy(3, "P-8 Poseidon", "In service", "US$256.5 million", 907D);
        Navy plane4 = new Navy(4, "EA-18G Growler", "In service", "US$68.2 million", 1900D);
        Navy plane5 = new Navy(5, "E-6 Mercury", "In service", "US$141.7 million", 980D);
        Navy plane6 = new Navy(6, "P-8 Poseidon", "In service", "US$256.5 million", 907D);
        Navy plane7 = new Navy(7, "F/A-18E/F Super Hornet", "In service", "US$66.0 million", 1915D);
        Navy plane8 = new Navy(8, "E-2 Hawkeye", "In service", "US$176 million", 650D);
        Navy plane9 = new Navy(9, "E-6 Mercury", "In service", "US$141.7 million", 980D);
        Navy plane10 = new Navy(10, "EP-3", "Active", "US$36 million", 700D);
        Navy plane11 = new Navy(11, "EA-18G Growler", "In service", "US$68.2 million", 1900D);
        Navy plane12 = new Navy(12, "P-3 Orion", "Active", "US$36 million", 761D);
        List<Navy> expected = List.of(plane, plane2, plane3, plane4, plane5, plane6, plane7, plane8, plane9,
                plane10, plane11, plane12);
        Assertions.assertEquals(expected, navies);
    }

    @Test
    public void save() {
        Navy test = new Navy("P-3 Orion", "Active", "US$36 million", 761D);
        Navy actual1 = navyController.save(test);
        List<Navy> actual = navyController.findAll();
        navyId = actual.get(actual.size() - 1).getId();
        navies.get(navies.size() - 1).setId(navyId);
        test.setId(navyId);
        assertEquals(test, actual1);
    }

    @After
    public void tearDown () {
        if (navyId != null) {
            navyController.delete(navyId);
        }
    }
}
