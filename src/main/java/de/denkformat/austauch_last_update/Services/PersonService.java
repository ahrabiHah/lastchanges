package de.denkformat.austauch_last_update.Services;

import de.denkformat.austauch_last_update.modell.Person;
import de.denkformat.austauch_last_update.modell.Roles;
import de.denkformat.austauch_last_update.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {


    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //find All user From DB
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    //find all user by ID
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

    //save user in DB
    public void save(Person person){
        personRepository.save(person);
    }
    //update Person in DB
    public Person updatePerson(Person person){
        return  personRepository.save(person);
    }
    public  Person findByEmail(String  email){
        Person result= personRepository.findByEmail(email);
        return  result;
    }

}
