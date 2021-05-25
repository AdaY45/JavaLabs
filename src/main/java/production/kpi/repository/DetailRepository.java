package production.kpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import production.kpi.pojo.plane.Detail;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {

    @Query("SELECT d FROM Detail d where d.description like %:filterText% " +
            " or d.model like %:filterText%")
    Detail findDetailByTitle(String filterText);
}
