package de.denkformat.austauch_last_update.Controller;


import de.denkformat.austauch_last_update.Services.NeederService;
import de.denkformat.austauch_last_update.Services.PersonService;
import de.denkformat.austauch_last_update.Services.TransactionService;
import de.denkformat.austauch_last_update.modell.Needer;
import de.denkformat.austauch_last_update.modell.Person;
import de.denkformat.austauch_last_update.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	@Autowired
	private NeederService neederService;
	@Autowired
	private PersonRepository personRepository;


	@Autowired
	public PersonController(PersonService personService, NeederService neederService) {
		this.personService = personService;
		this.neederService=neederService;
	}


	@GetMapping("/api/needers/")
	public List<Needer> findAllNeeders(){
		return  neederService.findAll();
	}
	@GetMapping("/api/needer/{id}")
	public Needer getNeeder(@PathVariable long id){
		return neederService.findById(id);
	}



	@GetMapping("/api/persons")
	public List<Person> findAll(){
		return  personService.findAll();
	}


	@GetMapping("/api/person/{id}")
	public Person getPerson(@PathVariable long id){
		return personService.findById(id);
	}

	@RequestMapping(value = "/api/person/addUser",method= RequestMethod.POST)
	@ResponseBody
	public Person create(@RequestBody Person person){
		return personRepository.save(person);
	}

	@RequestMapping(value = "/api/person/edit/{id}",method= RequestMethod.PUT)
	@ResponseBody
	public Person updatePerson(@RequestBody Person person,@PathVariable long id){
		Person exsistPerson= personService.findById(id);
		if (exsistPerson == null){
			throw new RuntimeException("test");
		}
		Person personResponse = (Person) personService.updatePerson(person);
		return personResponse;
	}

}


