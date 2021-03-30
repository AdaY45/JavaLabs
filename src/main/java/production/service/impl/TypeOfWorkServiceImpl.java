package production.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.repository.TypeOfWorkRepository;
import production.service.TypeOfWorkService;

@Service
public class TypeOfWorkServiceImpl implements TypeOfWorkService {
    @Autowired
    private TypeOfWorkRepository typeOfWorkRepository;

    @Override
    public TypeOfWorkRepository save(TypeOfWorkRepository typeOfWork) {
        return typeOfWorkRepository.save(typeOfWork);
    }

    @Override
    public TypeOfWorkRepository findByTitle(String title) {
        return typeOfWorkRepository.findByTitle(title);
    }
}