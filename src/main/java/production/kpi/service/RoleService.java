package production.kpi.service;

import production.kpi.pojo.people.Role;

public interface RoleService {
    Role save (Role role);

    Role findByName(String title);
}
