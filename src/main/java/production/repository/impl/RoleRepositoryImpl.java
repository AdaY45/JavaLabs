package production.repository.impl;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;
import production.pojo.people.Role;
import production.repository.RoleRepository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
    @Override
    public Role save(Role role) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Role findByTitle(String title) {
        throw new NotImplementedException("TODO");
    }
}
