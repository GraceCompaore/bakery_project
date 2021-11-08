package greta.cda.bakeryproject.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateProductOrderDto {
    private int unitPrice;

    private int quantity;

    private String productId;
}
