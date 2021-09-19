package greta.cda.bakeryproject.dao.impl;

import greta.cda.bakeryproject.dao.CommandDao;
import greta.cda.bakeryproject.entity.Command;
import greta.cda.bakeryproject.repository.CommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommandDaoInDb implements CommandDao {
    private final CommandRepository commandRepository;

    @Override
    public void add(Command command) {
        commandRepository.save(command);
    }

    @Override
    public List<Command> findAll() {
        return commandRepository.findAll();
    }

    @Override
    public Command findById(int id) {
        return commandRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Command command) {
        commandRepository.save(command);
    }

    @Override
    public void deleteById(int id) {
        commandRepository.deleteById(id);
    }


}
