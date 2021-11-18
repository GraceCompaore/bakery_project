package greta.cda.bakeryproject.dto;

import lombok.Data;

@Data
public class CreateProductOrderDto {
    private int unitPrice;

    private int quantity;

    private String productId;
}
