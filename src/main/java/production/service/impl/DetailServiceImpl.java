package production.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.pojo.plane.Detail;
import production.repository.DetailRepository;
import production.service.DetailService;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    private final DetailRepository detailRepository;

    public DetailServiceImpl(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    @Override
    public List<Detail> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public Detail findById(Integer id) {
        return detailRepository.findById(id);
    }

    @Override
    public Detail update(Detail detail) {
        return detailRepository.update(detail);
    }

    @Override
    public Detail save(Detail detail) {
        return detailRepository.save(detail);
    }

    @Override
    public boolean delete(Integer id) {
        return detailRepository.delete(id);
    }
}
