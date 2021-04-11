package production.kpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import production.kpi.pojo.people.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
