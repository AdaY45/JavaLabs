package production.kpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import production.kpi.pojo.people.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {

}

