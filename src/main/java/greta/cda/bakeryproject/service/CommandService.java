package greta.cda.bakeryproject.service;

import greta.cda.bakeryproject.dao.CommandDao;
import greta.cda.bakeryproject.entity.Person;
import greta.cda.bakeryproject.entity.Command;
import greta.cda.bakeryproject.entity.ProductOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandService {
    private final CommandDao commandDao;

    public List<Command> findAll() {
        return commandDao.findAll();
    }

    public void create(Person user, List<ProductOrder> productOrder) {
        Command myNewCommand = new Command(new Date(), user, new ArrayList<>());
        commandDao.add(myNewCommand);
    }

    public void deleteById(Integer id) {
        commandDao.deleteById(id);
    }

    public void update(int id, Command command) {
        commandDao.update(command);
    }

    public Command findById(int id) {
        return commandDao.findById(id);
    }
}
