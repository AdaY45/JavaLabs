package production.repository.impl;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import production.pojo.plane.Detail;
import production.repository.DetailRepository;

import java.util.List;

@Repository
public class DetailRepositoryImpl implements DetailRepository {
    @Override
    public List<Detail> findAll() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Detail findById(Integer id) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Detail update(Detail detail) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Detail save(Detail detail) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean delete(Integer id) {
        throw new NotImplementedException("TODO");
    }
}
