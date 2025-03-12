package com.project.personmanagement.person_app.repository;

import com.project.personmanagement.person_app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJDBC {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Person> personRowMapper = (rs, rowNum) -> {
        Person person = new Person();
        person.setId(rs.getLong("id"));
        person.setName(rs.getString("name"));
        person.setDob(rs.getString("dob"));
        return person;
    };

   
    public List<Person> getAllPersons() {
        String sql = "SELECT * FROM persons";
        return jdbcTemplate.query(sql, personRowMapper);
    }

    
    public int addPerson(Person person) {
        String sql = "INSERT INTO persons (name, dob) VALUES (?, ?)";
        return jdbcTemplate.update(sql, person.getName(), person.getDob());
    }

    
    public int updatePerson(Long id, Person person) {
        String sql = "UPDATE persons SET name = ?, dob = ? WHERE id = ?";
        return jdbcTemplate.update(sql, person.getName(), person.getDob(), id);
    }

    
    public int deletePerson(Long id) {
        String sql = "DELETE FROM persons WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
