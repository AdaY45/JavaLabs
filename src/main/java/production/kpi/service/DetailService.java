package production.kpi.service;

import production.kpi.pojo.plane.Detail;

import java.util.List;

public interface DetailService {
    List<Detail> findAll();

    Detail findById(Integer id);

    Detail update(Detail detail);

    Detail save(Detail detail);

    boolean delete(Integer id);
}
