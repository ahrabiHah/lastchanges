package de.denkformat.austauch_last_update.Services;

import de.denkformat.austauch_last_update.modell.Helper;
import de.denkformat.austauch_last_update.modell.Needer;
import de.denkformat.austauch_last_update.repository.HelperRepository;
import de.denkformat.austauch_last_update.repository.NeederRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HelperService {

    @Autowired
    private HelperRepository helperRepository;

    @Autowired
    public HelperService(HelperRepository helperRepository) {
        this.helperRepository = helperRepository;
    }

    //find All user From DB
    public List<Helper> findAll() {
        return helperRepository.findAll();
    }
    //find all user by ID
    public Helper findById(Long theId) {
        Optional<Helper> result = helperRepository.findById(theId);
        Helper helper = null;
        if (result.isPresent()) {
            helper = result.get();
        } else {
            throw new RuntimeException("didnt found" + theId);
        }
        return helper;

    }
}


