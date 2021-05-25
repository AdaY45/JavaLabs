package production.kpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import production.kpi.pojo.people.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT c FROM Client c where c.lastName like %:filterText% " +
            "or c.firstName like %:filterText% or c.email like %:filterText%")
    Client findClientByFullName(String filterText);
}
