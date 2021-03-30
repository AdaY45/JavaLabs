package production.service;

import production.pojo.people.Worker;
import production.pojo.plane.Navy;

import java.util.List;

public interface NavyService {
    Navy saveNavy(Navy plane);

    Navy getNavy(Integer id);

    List<Navy> getPlanesOfWorker(Worker worker);

    Navy updateNavy(Navy plane);

    boolean deleteNavy(Navy plane);

    List<Navy> findAll();
}
