package greta.cda.bakeryproject.controller;

import greta.cda.bakeryproject.entity.ProductOrder;
import greta.cda.bakeryproject.service.ProductOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class ProductOrderController {
    private final ProductOrderService productOrderService;

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public void create(@RequestBody ProductOrder productOrder) {
        productOrderService.create(productOrder.getId(), productOrder.getName());
    }

    @GetMapping
    public List<ProductOrder> findAll() {
        return productOrderService.findAll();
    }

    @DeleteMapping("{/id}")
    public void deleteById(@PathVariable Integer id){
        productOrderService.deleteById(id);}

    }

