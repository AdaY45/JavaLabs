package production.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import production.pojo.people.Role;
import production.repository.RoleRepository;
import production.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findByTitle(String title) {
        return roleRepository.findByTitle(title);
    }
}
