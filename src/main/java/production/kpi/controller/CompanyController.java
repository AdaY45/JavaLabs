package production.kpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import production.kpi.pojo.plane.Company;
import production.kpi.service.CompanyService;

import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    public Company findCompanyById( Integer id) {
        return companyService.findCompanyById(id);
    }

    public Company save(Company company) {
        return companyService.save(company);
    }

    public List<Company> findAll() {
        return companyService.findAll();
    }

    public Company update(Company company) {
        return companyService.updateCompany(company);
    }

    public boolean deleteById(Integer id) {
        return companyService.deleteCompany(id);
    }

    public List<Company> findCompanyByTitle(String filterText) {
        return companyService.findCompanyByTitle(filterText);
    }
}