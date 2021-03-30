package production.repository;

public interface TypeOfWorkRepository {
    TypeOfWorkRepository save (TypeOfWorkRepository typeOfWork);

    TypeOfWorkRepository findByTitle(String title);
}
