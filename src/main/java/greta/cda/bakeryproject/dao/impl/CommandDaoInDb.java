package greta.cda.bakeryproject.dao.impl;

import greta.cda.bakeryproject.dao.CommandDao;
import greta.cda.bakeryproject.entity.Command;
import greta.cda.bakeryproject.repository.CommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CommandDaoInDb implements CommandDao {
    private final CommandRepository commandRepository;

    @Override
    public Command add(Command command) {
        return commandRepository.save(command);
    }

    @Override
    public List<Command> findAll() {
        return commandRepository.findAll();
    }

    @Override
    public Optional<Command> findById(UUID id) {
        return commandRepository.findById(id);
    }

    @Override
    public Command update(Command command) {
        return commandRepository.save(command);
    }

    @Override
    public void deleteById(UUID id) {
        commandRepository.deleteById(id);
    }


}
