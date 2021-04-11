package production.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import production.kpi.pojo.plane.Navy;
import production.kpi.service.NavyService;

import java.util.List;

@Controller
public class NavyController {
    @Autowired
    private NavyService navyService;

    Navy findOrderById( Integer id) {
        return navyService.getNavy(id);
    }

    public Navy save(Navy plane) {
        return navyService.saveNavy(plane);
    }

    List<Navy> findAll() {
        return navyService.findAll();
    }
}
