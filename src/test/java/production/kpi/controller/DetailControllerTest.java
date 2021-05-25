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
import production.kpi.pojo.plane.Detail;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KpiApplication.class)
public class DetailControllerTest {
    @Autowired
    private DetailController detailController;
    private List<Detail> details;
    private Detail detail1;
    private Integer detailId = null;

    @Before
    public void setUp () {
        details = detailController.findAll();
        detail1 = new Detail("Wing", 2500.34, "F/A-18E/F Super Hornet");
        detail1.setId(1);
    }

    @Test
    public void findAll() {
        List<Detail> expected = new ArrayList<>();
        Detail detail2 = new Detail("Fuselage", 1500.34, "E-6 Mercury");
        expected.add(detail1);
        expected.add(detail2);
        detail2.setId(2);
        Assertions.assertEquals(expected, details);
    }

    @Test
    public void findById() {
        Detail actual = detailController.findById(1);
        Assertions.assertEquals(detail1, actual);
    }

    @Test
    public void save() {
        Detail test = new Detail("Fuselage", 1500.34, "E-6 Mercury");
        Detail actual1 = detailController.save(test);
        List<Detail> actual = detailController.findAll();
        detailId = actual.get(actual.size() - 1).getId();
        details.get(details.size() - 1).setId(detailId);
        test.setId(detailId);
        assertEquals(test, actual1);
    }

    @After
    public void tearDown () {
        if (detailId != null) {
            detailController.delete(detailId);
        }
    }

}