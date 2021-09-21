package greta.cda.bakeryproject.dao;

import greta.cda.bakeryproject.entity.Command;

import java.util.List;

public interface CommandDao {

    Command add(Command command);

    List<Command> findAll();

    Command findById(int id);

    void update(Command command);

    void deleteById(int id);
}
