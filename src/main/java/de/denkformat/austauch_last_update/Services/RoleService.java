package de.denkformat.austauch_last_update.Services;

import de.denkformat.austauch_last_update.modell.Roles;
import de.denkformat.austauch_last_update.repository.RolesRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    public RoleService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    //find All by Id(1=helper - 2= needer)
    public Roles findById(Long theId){
        Optional<Roles> result=rolesRepository.findById(theId);
        Roles roles =null;
        if (result.isPresent()){
            roles=result.get();
        }
        else {
            throw new RuntimeException("DindÄt found"+theId);
        }
        return roles;
    }
}
