package production.kpi.service;

import production.kpi.pojo.plane.PlanePart;

import java.util.List;

public interface PlanePartService {
    PlanePart findPartById(Integer id);

    PlanePart update(PlanePart part);

    List<PlanePart> findAll();

    PlanePart create(PlanePart planePart);
}

