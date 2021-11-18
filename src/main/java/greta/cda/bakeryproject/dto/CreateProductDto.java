package greta.cda.bakeryproject.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateProductDto implements Serializable {
    private String name;

    private int quantity; // product stock

    private double price;

    private String cover;

    private String category;
}

