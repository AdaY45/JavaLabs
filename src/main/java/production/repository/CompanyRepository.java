package production.repository;

import production.pojo.plane.Company;

import java.util.List;

public interface CompanyRepository {
    Company findCompanyById(long id);

    Company updateCompany(Company company);

    boolean deleteCompany(Integer id);

    Company save(Company company);

    List<Company> findAll();
}
