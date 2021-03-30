package production.repository;

import org.apache.commons.lang3.NotImplementedException;
import production.pojo.plane.PlanePart;

import java.util.List;

public interface PlanePartRepository {

    PlanePart findPartById(Integer id);

    PlanePart update(PlanePart part);

    List<PlanePart> findAll();

    PlanePart create(PlanePart planePart);
}
