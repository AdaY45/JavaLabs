package production.kpi.service;

import production.kpi.pojo.people.Worker;
import production.kpi.pojo.plane.Company;
import production.kpi.pojo.plane.Navy;

import java.util.List;

public interface CompanyService {
    Company findCompanyById(Integer id);

    Company updateCompany(Company company);

    boolean deleteCompany(Integer id);

    Company save(Company company);

    List<Company> findAll();

    List<Navy> findAllPlanesOfCompany(Integer id);

    List<Worker> findAllWorkersOfCompany(Integer id);
}