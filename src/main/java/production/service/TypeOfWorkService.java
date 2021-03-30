package production.service;

import production.repository.TypeOfWorkRepository;

public interface TypeOfWorkService {
    TypeOfWorkRepository save (TypeOfWorkRepository typeOfWork);

    TypeOfWorkRepository findByTitle(String title);
}
