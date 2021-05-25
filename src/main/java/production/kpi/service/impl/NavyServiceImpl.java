package production.kpi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.kpi.pojo.plane.Navy;
import production.kpi.repository.NavyRepository;
import production.kpi.service.NavyService;

import java.util.List;

@Service
public class NavyServiceImpl implements NavyService {
    @Autowired
    private NavyRepository navyRepository;

    @Override
    public Navy saveNavy(Navy plane) {
        return navyRepository.save(plane);
    }

    @Override
    public Navy getNavy(Integer id) {
        return navyRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Navy updateNavy(Navy plane) {
        return navyRepository.save(plane);
    }

    @Override
    public boolean deleteNavy(Integer planeId) {
        navyRepository.deleteById(planeId);
        return true;
    }

    @Override
    public List<Navy> findAll() {
        return navyRepository.findAll();
    }

    @Override
    public List<Navy> findNavyByDescription(String filterText) {
        return navyRepository.findNavyByDescription(filterText);
    }
}
