package production.repository;

import production.pojo.people.Role;

public interface RoleRepository {
    Role save (Role role);

    Role findByTitle(String title);

}
