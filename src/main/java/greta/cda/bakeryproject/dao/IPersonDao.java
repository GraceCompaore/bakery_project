package greta.cda.bakeryproject.dao;

import greta.cda.bakeryproject.entity.Person;

import java.util.List;
import java.util.UUID;

public interface IPersonDao {
    List<Person> findAll();

    void add(Person person);

    Person findById(UUID id);

    Person findByLogin(String login);

    void deleteById(UUID id);

    void update(Person person);

}
