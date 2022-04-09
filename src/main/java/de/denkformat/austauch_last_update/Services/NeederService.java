package de.denkformat.austauch_last_update.Services;

import de.denkformat.austauch_last_update.modell.Needer;
import de.denkformat.austauch_last_update.modell.Person;
import de.denkformat.austauch_last_update.repository.NeederRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NeederService {



    @Autowired
    private NeederRepository neederRepository;

    @Autowired
    public NeederService(NeederRepository neederRepository) {
        this.neederRepository = neederRepository;
    }

    //find All user From DB
    public List<Needer> findAll() {
        return neederRepository.findAll();
    }
    //find all user by ID
    public Needer findById(Long theId) {
        Optional<Needer> result = neederRepository.findById(theId);
        Needer needer = null;
        if (result.isPresent()) {
            needer = result.get();
        } else {
            throw new RuntimeException("didnt found" + theId);
        }
        return needer;

    }
}
