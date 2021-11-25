package greta.cda.bakeryproject.service;

import greta.cda.bakeryproject.dao.CommandDao;
import greta.cda.bakeryproject.dao.ProductDao;
import greta.cda.bakeryproject.dao.ProductOrderDao;
import greta.cda.bakeryproject.dto.CreateCommandRequestDto;
import greta.cda.bakeryproject.dto.CreateProductOrderDto;
import greta.cda.bakeryproject.entity.Command;
import greta.cda.bakeryproject.entity.Person;
import greta.cda.bakeryproject.entity.Product;
import greta.cda.bakeryproject.entity.ProductOrder;
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
    private final ProductDao productDao;
    private final ProductOrderDao productOrderDao;

    public List<Command> findAll() {
        return commandDao.findAll();
    }

    @Transactional
    public Command create(CreateCommandRequestDto commandDto) {
        Person personFound = personService.findByLogin(commandDto.getUser());
        Command commandToCreate = Command.builder()
                .dateCommand(new Date())
                .user(personFound)
                .build();
        Command commandCreated = commandDao.add(commandToCreate);

        commandDto.getProductOrderList().forEach((CreateProductOrderDto productOrderDto) -> {
            Product productFound = productDao.findById(UUID.fromString(productOrderDto.getProductId()))
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product with id=%s not found", productOrderDto.getProductId())));

            ProductOrder productOrder = ProductOrder.builder()
                    .product(productFound)
                    .command(commandCreated)
                    .quantity(productOrderDto.getQuantity())
                    .unitPrice(productOrderDto.getUnitPrice())
                    .build();

            productOrderDao.add(productOrder);
        });

        return commandCreated;
    }

    public void deleteById(String id) {
        commandDao.deleteById(UUID.fromString(id));
    }

    public Command findById(String id) {
        return commandDao.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Command with id=%s not found", id)));
    }
}
