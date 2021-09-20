package greta.cda.bakeryproject.dto;

import lombok.NonNull;

public class CreateProductOrderDto {
    @NonNull
    private int unitPrice;

    @NonNull
    private int quantity;

    @NonNull
    private String productId;

}
