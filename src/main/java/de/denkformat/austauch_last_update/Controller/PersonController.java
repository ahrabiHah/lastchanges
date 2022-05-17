package de.denkformat.austauch_last_update.Controller;


import de.denkformat.austauch_last_update.Services.NeederService;
import de.denkformat.austauch_last_update.Services.PersonService;
import de.denkformat.austauch_last_update.Services.RoleService;
import de.denkformat.austauch_last_update.modell.Needer;
import de.denkformat.austauch_last_update.modell.Person;
import de.denkformat.austauch_last_update.modell.Roles;
import de.denkformat.austauch_last_update.modell.dto.PersonDto;
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
	private RoleService roleService;



	public PersonController(PersonService personService, NeederService neederService, RoleService roleService) {
		this.personService = personService;
		this.neederService=neederService;
		this.roleService=roleService;
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
	public List<PersonDto> findAll(){
		return  personService.findAll();
	}


	@GetMapping("/api/person/{id}")
	public Person findPerson(@PathVariable long id){
		return personService.findById(id);
	}

	@RequestMapping(value = "/api/person/addUser",method= RequestMethod.POST)
	@ResponseBody
	public Person createNewPerson(@RequestBody Person person){
		return personRepository.save(person);
	}

	@RequestMapping(value = "/api/person/edit/{id}",method= RequestMethod.PUT)
	@ResponseBody
	public Person updatePersonInformation(@RequestBody Person person,@PathVariable long id){
		Person exsistPerson= personService.findById(id);
		if (exsistPerson == null){
			throw new RuntimeException("test");
		}
		Person personResponse = (Person) personService.updatePerson(person);
		return personResponse;
	}
	@GetMapping("/api/roles/{id}")
	public Roles listRoles(@PathVariable long id){
		return roleService.findById(id);
	}

}


