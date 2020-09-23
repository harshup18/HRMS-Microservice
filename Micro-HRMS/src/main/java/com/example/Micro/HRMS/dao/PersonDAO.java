package com.example.Micro.HRMS.dao;

import com.example.Micro.HRMS.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDAO {

    boolean insertPerson(UUID id, Person person);

    default boolean insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> getAllPeople();

    Optional<Person> getAPerson(UUID id);

    void deletePerson(UUID id);

    boolean updatePerson(UUID id, Person newPerson);


}
