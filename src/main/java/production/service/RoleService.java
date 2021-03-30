package production.service;

import production.pojo.people.Role;

public interface RoleService {
    Role save (Role role);

    Role findByTitle(String title);
}
