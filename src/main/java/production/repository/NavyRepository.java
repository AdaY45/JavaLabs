package production.repository;

import production.pojo.plane.Navy;

import java.util.List;

public interface NavyRepository {
    Navy findPlaneById(long id);

    Navy updatePlane(Navy plane);

    boolean deletePlane(Navy plane);

    Navy createPlane(Navy plane);

    List<Navy> findAll();
}
