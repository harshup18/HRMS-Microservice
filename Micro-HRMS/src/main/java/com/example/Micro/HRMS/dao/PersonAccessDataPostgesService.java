package com.example.Micro.HRMS.dao;

import com.example.Micro.HRMS.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("Postgres")
public class PersonAccessDataPostgesService implements PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonAccessDataPostgesService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insertPerson(UUID id, Person person) {
        final String sql = "INSERT INTO person (id, name, email, phone, team, role, doj)" +
                " VALUES" + "(" +
                person.getId() + ", '" + person.getName() + "', '" +
                person.getEmail() + "', '" + person.getPhone() + "', '" +
                person.getTeam() + "', '" + person.getRole() + "', ," +
                person.getDoj() + "'";
        jdbcTemplate.update(sql);
        return true;
    }

    @Override
    public List<Person> getAllPeople() {
        final String sql = "SELECT id, name, email, phone, team, role, doj FROM person";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            String team = resultSet.getString("team");
            String role = resultSet.getString("role");
            String doj = resultSet.getString("doj");
            return new Person(id, name, email, phone, team, role, doj);
        });
    }

    @Override
    public Optional<Person> getAPerson(UUID id) {
        final String sql = "SELECT id, name FROM person WHERE id = ?";
        Person person = jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                (resultSet, i) -> {
                    UUID personId = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    String team = resultSet.getString("team");
                    String role = resultSet.getString("role");
                    String doj = resultSet.getString("doj");
                    return new Person(personId, name, email, phone, team, role, doj);
                });
        return Optional.ofNullable(person);
    }

    @Override
    public void deletePerson(UUID id) {

    }

    @Override
    public boolean updatePerson(UUID id, Person newPerson) {
        return false;
    }
}
