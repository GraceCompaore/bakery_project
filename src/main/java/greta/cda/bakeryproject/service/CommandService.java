package greta.cda.bakeryproject.service;

import greta.cda.bakeryproject.dao.CommandDao;
import greta.cda.bakeryproject.dto.CreateCommandRequestDto;
import greta.cda.bakeryproject.dto.CreateProductOrderDto;
import greta.cda.bakeryproject.entity.Command;
import greta.cda.bakeryproject.entity.Person;
import greta.cda.bakeryproject.entity.Product;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommandService {
    private static final Logger logger = LoggerFactory.getLogger(CommandService.class);
    private final CommandDao commandDao;
    private final PersonService personService;
    private final ProductOrderService productOrderService;
    private final ProductService productService;

    public List<Command> findAll() {
        return commandDao.findAll();
    }

    public void create(CreateCommandRequestDto commandDto) {
        Person foundPerson = personService.findById(UUID.fromString(commandDto.getUserId()));

        try {
            Command myNewCommand = new Command(new Date(), foundPerson, new ArrayList<>());
            Command savedCommand = commandDao.add(myNewCommand);

            for (CreateProductOrderDto productOrderItem : commandDto.getProductOrderList()) {
                Product foundProduct = productService.findById(productOrderItem.getProductId());
                productOrderService.add(productOrderItem.getUnitPrice(), productOrderItem.getQuantity(), savedCommand, foundProduct);
            }

            logger.info("Command create successfully !");
        } catch (Exception e) {
            logger.error("Command creation fail");
        }
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
