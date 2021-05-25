package production.kpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import production.kpi.pojo.people.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {

    @Query("SELECT w FROM Worker w where w.lastName like %:filterText% " +
            "or w.firstName like %:filterText% or w.email like %:filterText%")
    Worker findWorkerByLastname(String filterText);
}

