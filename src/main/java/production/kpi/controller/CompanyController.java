package production.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import production.kpi.pojo.plane.Company;
import production.kpi.service.CompanyService;

import java.util.List;


public class CompanyController {
    @Autowired
    private CompanyService companyService;

    Company findCompanyById( Integer id) {
        return companyService.findCompanyById(id);
    }


    List<Company> findAll() {
        return companyService.findAll();
    }
}