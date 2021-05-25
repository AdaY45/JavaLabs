package production.kpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import production.kpi.pojo.plane.Navy;

import java.util.List;

@Repository
public interface NavyRepository extends JpaRepository<Navy, Integer> {

    @Query("SELECT n FROM Navy n where n.model like %:filterText%")
    List<Navy> findNavyByDescription(String filterText);

}
