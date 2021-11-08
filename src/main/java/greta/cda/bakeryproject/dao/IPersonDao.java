package greta.cda.bakeryproject.dao;

import greta.cda.bakeryproject.entity.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPersonDao {
    List<Person> findAll();

    Person add(Person person);

    Optional<Person> findById(UUID id);

    Optional<Person> findByLogin(String login);

    void deleteById(UUID id);

    Person update(Person person);

}
