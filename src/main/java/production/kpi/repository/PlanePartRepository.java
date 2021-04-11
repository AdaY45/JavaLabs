package production.kpi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import production.kpi.pojo.plane.PlanePart;

@Repository
public interface PlanePartRepository extends JpaRepository<PlanePart, Integer> {

}
