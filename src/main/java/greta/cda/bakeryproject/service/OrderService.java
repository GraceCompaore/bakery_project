package greta.cda.bakeryproject.service;


import greta.cda.bakeryproject.dao.OrderDao;
import greta.cda.bakeryproject.entity.Order;
import greta.cda.bakeryproject.entity.Person;
import greta.cda.bakeryproject.entity.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor

public class OrderService {
    private final PersonService personService;
    private final OrderDao orderDao;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void create(Product product, Person person){


    }
}
