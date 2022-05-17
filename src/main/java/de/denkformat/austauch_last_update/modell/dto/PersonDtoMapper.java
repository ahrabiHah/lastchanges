package de.denkformat.austauch_last_update.modell.dto;

import de.denkformat.austauch_last_update.modell.Person;
import de.denkformat.austauch_last_update.modell.Roles;

import java.util.Set;

public class PersonDtoMapper {



     public static Person fromDto(PersonDto personDto){

         Person person = new Person();
         person.setFirstName(personDto.getFirstName());
         person.setLast_name(personDto.getLast_name());
         person.setCity(personDto.getCity());
         person.setDateJoined(personDto.getDateJoined());
         person.setCountry(personDto.getCountry());
         person.setImage(personDto.getImage());
         person.setActive(personDto.isActive());
         person.setContact(personDto.getContact());
         person.setRoles(personDto.getRoles());



         return person;
     }
     public static PersonDto toDoto(Person person){

         PersonDto personDto= new PersonDto();
         personDto.setActive(person.isActive());
         personDto.setCity(person.getCity());
         personDto.setCountry(person.getCountry());
         personDto.setImage(person.getImage());
         personDto.setFirstName(person.getFirstName());
         personDto.setLast_name(person.getLast_name());
         personDto.setDateJoined(person.getDateJoined());
         personDto.setContact(person.getContact());
         personDto.setRoles(person.getRoles());

         return personDto;
     }



}
