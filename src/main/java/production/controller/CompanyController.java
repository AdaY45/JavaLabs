package production.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import production.pojo.plane.Company;
import production.service.CompanyService;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @GetMapping("/id")
    Company findCompanyById(@RequestParam(name = "id") Long id) {
        return companyService.findCompanyById(id);
    }

    @GetMapping
    List<Company> findAll() {
        return companyService.findAll();
    }
}