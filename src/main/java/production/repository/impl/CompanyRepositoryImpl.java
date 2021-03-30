package production.repository.impl;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import production.pojo.plane.Company;
import production.repository.CompanyRepository;

import java.util.List;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {
    @Override
    public Company findCompanyById(long id) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Company updateCompany(Company company) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean deleteCompany(Integer id) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Company save(Company company) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public List<Company> findAll() {
        throw new NotImplementedException("TODO");
    }
}
