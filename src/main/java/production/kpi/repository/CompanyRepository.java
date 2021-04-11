package production.kpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import production.kpi.pojo.plane.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
