package production.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import production.pojo.plane.Navy;
import production.service.NavyService;
import java.util.List;

@RestController
public class NavyController {
    @Autowired
    private NavyService navyService;
    @GetMapping("/id")
    Navy findOrderById(@RequestParam(name = "id") Integer id) {
        return navyService.getNavy(id);
    }

    @GetMapping
    List<Navy> findAll() {
        return navyService.findAll();
    }
}
