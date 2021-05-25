package production.kpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import production.kpi.pojo.plane.Company;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("SELECT c FROM Company c LEFT JOIN FETCH c.workers")
    List<Company> findAll();

    @Query("SELECT c FROM Company c LEFT JOIN FETCH c.workers where c.id = :id")
    Optional<Company> findById(Integer id);

    List<Company> findCompaniesByNameStartsWith(String filterText);
}
