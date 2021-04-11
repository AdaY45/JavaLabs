package production.kpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import production.kpi.pojo.plane.Detail;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {

}
