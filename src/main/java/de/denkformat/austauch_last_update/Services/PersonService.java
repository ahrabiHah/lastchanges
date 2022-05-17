package de.denkformat.austauch_last_update.Services;

import de.denkformat.austauch_last_update.modell.Person;
import de.denkformat.austauch_last_update.modell.dto.PersonDto;
import de.denkformat.austauch_last_update.modell.dto.PersonDtoMapper;
import de.denkformat.austauch_last_update.repository.PersonRepository;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    //find All Persons From DB
    public List<PersonDto> findAll() {

        List<Person>persons =personRepository.findAll();
        List<PersonDto> personDtoList = new ArrayList<>();
        for ( Person person :persons){
            PersonDto personDto = PersonDtoMapper.toDoto(person );
            personDtoList.add(personDto);

        }
         return personDtoList;
    }
    //find all Person by ID
    public Person findById(Long theId) {
        Optional<Person> result = personRepository.findById(theId);
        Person theUser = null;
        if (result.isPresent()) {
            theUser = result.get();
        } else {
            throw new RuntimeException("didnt found" + theId);
        }
        return theUser;

    }

    //save Person in DB
    public void save(Person person){
        personRepository.save(person);
    }
    //update Person in DB
    public Person updatePerson(Person person){
        return  personRepository.save(person);
    }
}
