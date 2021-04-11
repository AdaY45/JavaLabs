package production.kpi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.kpi.pojo.plane.TypeOfWork;
import production.kpi.repository.TypeOfWorkRepository;
import production.kpi.service.TypeOfWorkService;

@Service
public class TypeOfWorkServiceImpl implements TypeOfWorkService {
    @Autowired
    private TypeOfWorkRepository typeOfWorkRepository;

    @Override
    public TypeOfWork save(TypeOfWork typeOfWork) {
        return typeOfWorkRepository.save(typeOfWork);
    }

    @Override
    public TypeOfWork findByTitle(String title) {
        return typeOfWorkRepository.findByTitle(title);
    }
}