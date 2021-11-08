package greta.cda.bakeryproject.service;

import greta.cda.bakeryproject.dao.CommandDao;
import greta.cda.bakeryproject.dto.CreateCommandRequestDto;
import greta.cda.bakeryproject.entity.Command;
import greta.cda.bakeryproject.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommandService {
    private final CommandDao commandDao;
    private final PersonService personService;

    public List<Command> findAll() {
        return commandDao.findAll();
    }

    @Transactional
    public Command create(CreateCommandRequestDto commandDto) {
        Person personFound = personService.findById(commandDto.getUserId());
        Command myNewCommand = new Command(new Date(), personFound);
        return commandDao.add(myNewCommand);
    }

    public void deleteById(String id) {
        commandDao.deleteById(UUID.fromString(id));
    }

    @Transactional
    public Command update(String id, Command command) {
        Command commandToUpdate = commandDao.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Command with id=%s not found", id)));

        commandToUpdate.setDateCommand(command.getDateCommand());
        commandToUpdate.setUser(command.getUser());

        return commandDao.update(commandToUpdate);
    }

    public Command findById(String id) {
        return commandDao.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Command with id=%s not found", id)));
    }
}
