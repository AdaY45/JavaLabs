package production.repository;

import production.pojo.plane.Detail;

import java.util.List;

public interface DetailRepository {
    List<Detail> findAll();

    Detail findById(Integer id);

    Detail update(Detail detail);

    Detail save(Detail detail);

    boolean delete(Integer id);
}
