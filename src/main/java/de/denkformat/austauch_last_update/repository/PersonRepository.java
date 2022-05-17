package de.denkformat.austauch_last_update.repository;

import de.denkformat.austauch_last_update.modell.Person;
import java.util.List;

import de.denkformat.austauch_last_update.modell.dto.PersonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface PersonRepository extends JpaRepository< Person,Long> {


}



