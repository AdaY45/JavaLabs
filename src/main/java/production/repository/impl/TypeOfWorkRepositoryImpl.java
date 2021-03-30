package production.repository.impl;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import production.repository.TypeOfWorkRepository;

@Repository
public class TypeOfWorkRepositoryImpl implements TypeOfWorkRepository {
    @Override
    public TypeOfWorkRepository save(TypeOfWorkRepository typeOfWork) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public TypeOfWorkRepository findByTitle(String title) {
        throw new NotImplementedException("TODO");
    }
}
