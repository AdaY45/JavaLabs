package production.service;

import production.pojo.people.Worker;
import production.pojo.plane.Company;
import production.pojo.plane.Navy;

import java.util.List;

public interface CompanyService {
    Company findCompanyById(long id);

    Company updateCompany(Company company);

    boolean deleteCompany(Integer id);

    Company save(Company company);

    List<Company> findAll();

    List<Navy> findAllPlanesOfCompany(Long id);

    List<Worker> findAllWorkersOfCompany(Long id);
}