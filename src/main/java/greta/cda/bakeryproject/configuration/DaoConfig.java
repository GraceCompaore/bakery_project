package greta.cda.bakeryproject.configuration;


import greta.cda.bakeryproject.dao.ProductDao;
import greta.cda.bakeryproject.dao.ProductDaoInMemory;
import greta.cda.bakeryproject.domain.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

        @Bean
        ProductDao productDao() {
            System.out.println("On utilise un dao en mémoire");
            ProductDaoInMemory productDaoInMemory = new ProductDaoInMemory();
            return productDaoInMemory;
        }
}
