package production.kpi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.kpi.pojo.plane.PlanePart;
import production.kpi.repository.PlanePartRepository;
import production.kpi.service.PlanePartService;

import java.util.List;

@Service
public class PlanePartServiceImpl implements PlanePartService {
    @Autowired
    private PlanePartRepository planePartRepository;

    @Override
    public PlanePart findPartById(Integer id) {
        return planePartRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public PlanePart update(PlanePart part) {
        return planePartRepository.save(part);
    }

    @Override
    public List<PlanePart> findAll() {
        return planePartRepository.findAll();
    }

    @Override
    public PlanePart create(PlanePart planePart) {
        return planePartRepository.save(planePart);
    }
}
