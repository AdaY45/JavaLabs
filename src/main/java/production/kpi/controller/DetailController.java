package production.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import production.kpi.pojo.plane.Detail;
import production.kpi.service.DetailService;

import java.util.List;

@Controller
public class DetailController {
    private final DetailService detailService;

    @Autowired
    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    public List<Detail> findAll(){
        return detailService.findAll();
    }

    public Detail findById(Integer id) {
        return detailService.findById(id);
    }

    public Detail update(Detail detail) {
        return detailService.update(detail);
    }

    public Detail save(Detail detail) {
        return detailService.save(detail);
    }

    public boolean delete(Integer id) {
        return detailService.delete(id);
    }

    public Detail findDetailByTitle(String filterText) {
        return detailService.findDetailByTitle(filterText);
    }
}
