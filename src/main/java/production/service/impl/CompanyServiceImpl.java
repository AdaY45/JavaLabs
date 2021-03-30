package production.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.pojo.people.Worker;
import production.pojo.plane.Company;
import production.pojo.plane.Navy;
import production.repository.CompanyRepository;
import production.service.CompanyService;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company findCompanyById(long id) {
        return companyRepository.findCompanyById(id);
    }

    @Override
    public Company updateCompany(Company company) {
        return companyRepository.updateCompany(company);
    }

    @Override
    public boolean deleteCompany(Integer id) {
        return companyRepository.deleteCompany(id);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public List<Navy> findAllPlanesOfCompany(Long id) {
        Company company = companyRepository.findCompanyById(id);
        return company.getPlanes();
    }

    @Override
    public List<Worker> findAllWorkersOfCompany(Long id) {
        Company company = companyRepository.findCompanyById(id);
        return company.getWorkers();
    }
}
