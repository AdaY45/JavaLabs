package production.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.pojo.people.Worker;
import production.pojo.plane.Navy;
import production.repository.NavyRepository;
import production.service.NavyService;

import java.util.List;

@Service
public class NavyServiceImpl implements NavyService {
    @Autowired
    private NavyRepository navyRepository;

    @Override
    public Navy saveNavy(Navy plane) {
        return navyRepository.createPlane(plane);
    }

    @Override
    public Navy getNavy(Integer id) {
        return navyRepository.findPlaneById(id);
    }

    @Override
    public List<Navy> getPlanesOfWorker(Worker worker) {
        return worker.getPlanes();
    }

    @Override
    public Navy updateNavy(Navy plane) {
        return navyRepository.updatePlane(plane);
    }

    @Override
    public boolean deleteNavy(Navy plane) {
        return navyRepository.deletePlane(plane);
    }

    @Override
    public List<Navy> findAll() {
        return navyRepository.findAll();
    }
}
