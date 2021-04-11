package production.kpi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.kpi.pojo.people.Worker;
import production.kpi.pojo.plane.Company;
import production.kpi.pojo.plane.Navy;
import production.kpi.repository.CompanyRepository;
import production.kpi.service.CompanyService;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company findCompanyById(Integer id) {
        return companyRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Company updateCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public boolean deleteCompany(Integer id) {
        companyRepository.deleteById(id);
        return true;
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
    public List<Navy> findAllPlanesOfCompany(Integer id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        return company.getPlanes();
    }

    @Override
    public List<Worker> findAllWorkersOfCompany(Integer id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        return company.getWorkers();
    }
}
