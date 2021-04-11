package production.kpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import production.kpi.pojo.plane.Navy;

@Repository
public interface NavyRepository extends JpaRepository<Navy, Integer> {

}
