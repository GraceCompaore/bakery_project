package greta.cda.bakeryproject.dao;

import greta.cda.bakeryproject.entity.Person;

import java.util.List;

public interface IPersonDao {
    List<Person> findAll();

    void add(Person person);

    Person findById(int id);

    Person findByLogin(String login);

    void deleteById(int id);

    void update(Person person);

}
