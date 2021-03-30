package production.repository.impl;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import production.pojo.plane.PlanePart;
import production.repository.PlanePartRepository;

import java.util.List;

@Repository
public class PlanePartRepositoryImpl implements PlanePartRepository {
    public PlanePart findPartById(Integer id) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public PlanePart update(PlanePart part) {
        throw new NotImplementedException("TODO");
    }

    public List<PlanePart> findAll() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public PlanePart create(PlanePart planePart) { throw new NotImplementedException("TODO");
    }
}
