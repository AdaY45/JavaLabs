package production.kpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import production.kpi.pojo.plane.TypeOfWork;

@Repository
public interface TypeOfWorkRepository extends JpaRepository<TypeOfWork, Integer> {

    @Query("SELECT t FROM TypeOfWork t where t.title = :title")
    TypeOfWork findByTitle(String title);
}
