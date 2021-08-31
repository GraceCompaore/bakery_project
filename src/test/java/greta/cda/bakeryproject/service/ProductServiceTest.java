package greta.cda.bakeryproject.service;

import greta.cda.bakeryproject.dao.ProductDao;
import greta.cda.bakeryproject.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {
    ProductDao mockedDao;
    ProductService productService;


    @Before
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
        productService.add("Toto",1,1);

        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
        verify(mockedDao).add(productArgumentCaptor.capture());

        Product productSentToDAO = productArgumentCaptor.getValue();
        assertThat(productSentToDAO.getId(), is(notNullValue()));
        assertThat(productSentToDAO.getName(), is("Toto"));
    }



}