package production.kpi.service;

import production.kpi.pojo.plane.TypeOfWork;
import production.kpi.repository.TypeOfWorkRepository;

public interface TypeOfWorkService {
    TypeOfWork save(TypeOfWork typeOfWork);

    TypeOfWork findByTitle(String title);
}
