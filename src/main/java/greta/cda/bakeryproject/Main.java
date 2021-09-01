package greta.cda.bakeryproject;

import greta.cda.bakeryproject.cli.CliController;

import greta.cda.bakeryproject.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);

        ProductService productService = applicationContext.getBean(ProductService.class);
        initData(productService);

       // CliController cliController = applicationContext.getBean(CliController.class);
        //cliController.start();

       /* ProductDao productDao = new ProductDaoInMemory();
        ProductService productService = new ProductService(productDao);
        CliController cliController = new CliController(productService);
        initData(productService);
        cliController.start(); */

    }

    /**
     * Initialise quelques données par défaut afin de ne pas tout perdre à chaque redémarrage
     * @param productService
     */
    private static void initData(ProductService productService) {
        productService.add("croissant",1, 2);
        productService.add("pain au chocolat", 2, 3);
    }
}
