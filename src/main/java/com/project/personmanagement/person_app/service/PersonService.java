package com.project.personmanagement.person_app.service;

import com.project.personmanagement.person_app.model.Person;
import com.project.personmanagement.person_app.repository.PersonJDBC;
//import com.project.personmanagement.person_app.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    
    //@Autowired
    //private PersonRepository personRepository; // JPA Repository (Commented)

    @Autowired
    private PersonJDBC personJDBC; // JDBC Implementation

    public List<Person> getAllPersons() {
        // return personRepository.findAll(); // JPA Method
        return personJDBC.getAllPersons(); // JDBC Method
    }

    public void addPerson(Person person) {
        // personRepository.save(person); // JPA Method
        personJDBC.addPerson(person); // JDBC Method
    }

    public void updatePerson(Long id, Person updatedPerson) {
        // Optional<Person> existingPersonOpt = personRepository.findById(id);
        // if (existingPersonOpt.isPresent()) {
        //     Person existingPerson = existingPersonOpt.get();
        //     existingPerson.setName(updatedPerson.getName());
        //     existingPerson.setDob(updatedPerson.getDob());
        //     personRepository.save(existingPerson);
        // } else {
        //     throw new RuntimeException("Person not found with ID: " + id);
        // }
        personJDBC.updatePerson(id, updatedPerson); // JDBC Method
    }

    public void deletePerson(Long id) {
        // personRepository.deleteById(id); // JPA Method
        personJDBC.deletePerson(id); // JDBC Method
    }
}
