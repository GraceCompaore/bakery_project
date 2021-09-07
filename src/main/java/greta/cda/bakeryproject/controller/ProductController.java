package greta.cda.bakeryproject.controller;

import greta.cda.bakeryproject.entity.Product;
import greta.cda.bakeryproject.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable int id) {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Product product) {
        productService.add(product.getId(), product.getName(), product.getQuantity(), product.getPrice());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Product product) {
        productService.update(id, product);
    }

    @GetMapping("/name/{queryName}")
    public List<Product> findByName(@PathVariable String queryName) {
        return productService.findProductContainingName(queryName);
    }

}


