package greta.cda.bakeryproject.cli;

import greta.cda.bakeryproject.domain.Product;
import greta.cda.bakeryproject.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public List<Product> findAll() {
       return productService.findAll();
    }

    @GetMapping ("/product/:id")
    public Product findbyId(@PathParam("id") String id) {
        return productService.findById(id);
    }

    @PostMapping ("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestParam String name, int quantity, int price) {
        Product item = new Product(UUID.randomUUID(), name,quantity, price);
        productService.add("toto",1, 2);
    }
}


