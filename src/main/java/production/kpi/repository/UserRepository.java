package production.kpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import production.kpi.pojo.people.User;
import production.kpi.pojo.plane.Company;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles Role where u.email = :email")
    User findUserByEmail(String email);

    List<User> findUsersByLastNameStartingWith(String filterText);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles")
    List<User> findAll();
}