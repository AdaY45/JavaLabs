package production.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import production.kpi.pojo.plane.Navy;
import production.kpi.service.NavyService;

import java.util.List;

@Controller
public class NavyController {
    @Autowired
    private NavyService navyService;

    Navy findOrderById(Integer id) {
        return navyService.getNavy(id);
    }

    public Navy save(Navy plane) {
        return navyService.saveNavy(plane);
    }

    public List<Navy> findAll() {
        return navyService.findAll();
    }

    public Navy update(Navy plane) {
        return navyService.updateNavy(plane);
    }

    public boolean delete(Integer planeId) {
        return navyService.deleteNavy(planeId);
    }

    public List<Navy> findNavyByDescription(String filterText) {
        return navyService.findNavyByDescription(filterText);
    }
}
