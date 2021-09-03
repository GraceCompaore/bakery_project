package greta.cda.bakeryproject.cli;

import greta.cda.bakeryproject.domain.Product;
import greta.cda.bakeryproject.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findbyId(@PathVariable String id) {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Product product) {
        productService.add(product.getId(),product.getName(), product.getQuantity(), product.getPrice());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id)
    {
        productService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Product product) {
        productService.update(id, product);
    }

}



