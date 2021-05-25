package production.kpi.service;

import production.kpi.pojo.plane.TypeOfWork;

public interface TypeOfWorkService {
    TypeOfWork save(TypeOfWork typeOfWork);

    TypeOfWork findByTitle(String title);
}
