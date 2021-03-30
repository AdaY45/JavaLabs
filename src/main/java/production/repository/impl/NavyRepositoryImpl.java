package production.repository.impl;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import production.pojo.plane.Navy;
import production.repository.NavyRepository;

import java.util.List;


@Repository
public class NavyRepositoryImpl implements NavyRepository {
    public Navy findPlaneById(long id) {
        throw new NotImplementedException("TODO");
    }

    public Navy updatePlane(Navy plane) {
        throw new NotImplementedException("TODO");
    }

    public boolean deletePlane(Navy plane) {return false;}

    public Navy createPlane(Navy plane) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public List<Navy> findAll() {
        throw new NotImplementedException("TODO");
    }

}
