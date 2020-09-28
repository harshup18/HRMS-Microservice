package com.example.Micro.HRMS.service;

import com.example.Micro.HRMS.dao.PersonDAO;
import com.example.Micro.HRMS.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDAO personDAO;

    @Autowired
    public PersonService(@Qualifier("Postgres") PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public void addPerson(Person person) {
        personDAO.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDAO.getAllPeople();
    }

    public Optional<Person> getAPerson(UUID id) {
        return personDAO.getAPerson(id);
    }

    public void deletePerson(UUID id) {
        personDAO.deletePerson(id);
    }

    public boolean updatePerson(UUID id, Person newPerson){
        return personDAO.updatePerson(id, newPerson);
    }


}
