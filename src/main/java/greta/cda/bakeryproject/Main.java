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

         }

    /**
     * Initialise quelques données par défaut afin de ne pas tout perdre à chaque redémarrage
     * @param productService
     */
    private static void initData(ProductService productService) {
        productService.add("aa1","croissant",1, 2);
        productService.add("aa2","pain au chocolat", 2, 3);
    }
}
