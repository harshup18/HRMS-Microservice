package com.example.Micro.HRMS.dao;

import com.example.Micro.HRMS.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("PersonDAO")
public class PersonAccessDataService implements PersonDAO {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public boolean insertPerson(UUID id, Person person) {
        DB.add(new Person(id,
                person.getName(),
                person.getEmail(),
                person.getPhone(),
                person.getTeam(),
                person.getRole(),
                person.getDoj()));
        return true;
    }

    @Override
    public List<Person> getAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> getAPerson(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deletePerson(UUID id) {
        Optional<Person> personMayBe = getAPerson(id);
        personMayBe.ifPresent(person -> DB.remove(person));
    }

    @Override
    public boolean updatePerson(UUID id, Person newPerson) {
        return getAPerson(id)
                .map(p -> {
                    int indexOfPerson = DB.indexOf(p);
                    if (indexOfPerson >= 0) {
                        DB.set(indexOfPerson, new Person(id,
                                newPerson.getName(),
                                newPerson.getEmail(),
                                newPerson.getPhone(),
                                newPerson.getTeam(),
                                newPerson.getRole(),
                                newPerson.getDoj()));
                        return true;
                    }
                    return false;
                }).orElse(false);
    }
}
