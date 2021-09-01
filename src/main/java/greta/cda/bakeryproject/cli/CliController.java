package greta.cda.bakeryproject.cli;


import greta.cda.bakeryproject.domain.Product;
import greta.cda.bakeryproject.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Scanner;
import java.util.List;

public class CliController {
    private ProductService productService;

    public CliController(ProductService productService) {

        this.productService = productService;
    }


    public void start() {
        System.out.println("--------------------");
        System.out.println("1 - Afficher l'ensemble des produits");
        System.out.println("2 - Ajouter un produit");
        System.out.println("3 - Rechercher un produit par son ID");
        System.out.println("--------------------");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
            /*
            if (choice.equals("1")) {
                List <Product> allProducts = productService.findAll();
                for (Product currentProduct : allProducts) {
                    System.out.println(currentProduct);
                }
            }
            else if (choice.equals("2")){
                System.out.println("Entrez le nom du produit");
                String productName = scanner.next();
                System.out.println("Entrez la quantité du produit");
                int productQuantity = scanner.nextInt();
                System.out.println("Entrez le prix du produit");
                int productPrice = scanner.nextInt();
                productService.add(productName, productQuantity, productPrice);
                System.out.println("Produit ajouté");
                System.out.println("la nouvelle liste de produits est :");
                List <Product> newProductlist = productService.findAll();
            } */
        switch (choice) {
            case "1":
                List<Product> allProducts = productService.findAll();
                for (Product currentProduct : allProducts) {
                    System.out.println(currentProduct);
                }
                break;
            case "2":
                System.out.println("Entrez le nom du produit");
                String productName = scanner.next();
                System.out.println("Entrez la quantité du produit");
                int productQuantity = scanner.nextInt();
                System.out.println("Entrez le prix du produit");
                int productPrice = scanner.nextInt();
                productService.add(productName, productQuantity, productPrice);
                System.out.println("Produit ajouté");
                System.out.println("la nouvelle liste de produits est :");
                List<Product> newProductlist = productService.findAll();
                System.out.println(productService.findAll());
                break;
            case "3":
                System.out.println("Entrez l'Id du produit");
                String productId = scanner.next();
                productService.findById();
                System.out.println("Le produit recherché est : ");
                List<Product> searchProduct = productService.findById();
                System.out.println(productService.findById());
                break;
                /*
            case "4" :
                System.out.println("Entrez le nom du produit");
                String searchedName = scanner.next();
                productService.findProductContainingName(searchedName).forEach(product -> System.out.println(product));

        }*/
        }
    }
}