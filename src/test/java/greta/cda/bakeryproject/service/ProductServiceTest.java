package greta.cda.bakeryproject.service;

import greta.cda.bakeryproject.dao.ProductDao;
import greta.cda.bakeryproject.entity.Product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.hamcrest.CoreMatchers.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceTest {
    ProductDao mockedDao;
    ProductService productService;


    @BeforeEach
    public void setUp() {
        mockedDao = mock(ProductDao.class);
        productService = new ProductService(mockedDao);
    }

    /*@Test
    public void findAll() {
        List<Product> allProducts = Arrays.asList(
                new Product(UUID.randomUUID(), "baguette",1,2),
                new Product(UUID.randomUUID(), "tradition",2,3)
        );
        // lorsque le service va appeler cette méthode sur le mock
        // le mock lui retournera la liste ci-dessus
        when(mockedDao.findAll().thenReturn(allProducts));

        // j'appelle la méthode testée
        List<Product> actualProducts = productService.findAll();

        // je m'assure que son résultat est bien celui que j'attends
        assertThat(actualProducts, equalTo(allProducts));
    }*/
    @Test
    public void add() {
        productService.add(3,"Toto",1,1);

        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
        verify(mockedDao).add(productArgumentCaptor.capture());

        Product productSentToDAO = productArgumentCaptor.getValue();
        assertEquals(productSentToDAO.getId(), is(notNullValue()));
        assertEquals(productSentToDAO.getName(), is("Toto"));
    }



}