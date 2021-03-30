package production.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.pojo.plane.PlanePart;
import production.repository.PlanePartRepository;
import production.service.PlanePartService;

import java.util.List;

@Service
public class PlanePartServiceImpl implements PlanePartService {
    @Autowired
    private PlanePartRepository planePartRepository;

    @Override
    public PlanePart findPartById(Integer id) {
        return planePartRepository.findPartById(id);
    }

    @Override
    public PlanePart update(PlanePart part) {
        return planePartRepository.update(part);
    }

    @Override
    public List<PlanePart> findAll() {
        return planePartRepository.findAll();
    }

    @Override
    public PlanePart create(PlanePart planePart) {
        return planePartRepository.create(planePart);
    }
}
