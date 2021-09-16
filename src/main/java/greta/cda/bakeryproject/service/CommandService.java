package greta.cda.bakeryproject.service;

import greta.cda.bakeryproject.dao.CommandDao;
import greta.cda.bakeryproject.entity.Person;
import greta.cda.bakeryproject.entity.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandService {
    private final CommandDao commandDao;

    public List<Command> findAll() {
        return commandDao.findAll();
    }

    public void create(Integer id, String name, Person user) {
        Command myNewCommand = new Command(id, name, user, new ArrayList<>());
        commandDao.add(myNewCommand);
    }

    public void deleteById(Integer id) {
        commandDao.deleteById(id);
    }

    public void update(int id, Command command) {
        commandDao.update(command);
    }

    private Command findById(int id) {
        return commandDao.findById(id);
    }
}
