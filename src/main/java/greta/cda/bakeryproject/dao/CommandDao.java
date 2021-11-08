package greta.cda.bakeryproject.dao;

import greta.cda.bakeryproject.entity.Command;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommandDao {

    Command add(Command command);

    List<Command> findAll();

    Optional<Command> findById(UUID id);

    Command update(Command command);

    void deleteById(UUID id);
}
