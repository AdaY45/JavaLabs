package production.kpi.service;

import production.kpi.pojo.plane.Navy;

import java.util.List;

public interface NavyService {
    Navy saveNavy(Navy plane);

    Navy getNavy(Integer id);

    Navy updateNavy(Navy plane);

    boolean deleteNavy(Integer planeId);

    List<Navy> findAll();

    List<Navy> findNavyByDescription(String filterText);
}
