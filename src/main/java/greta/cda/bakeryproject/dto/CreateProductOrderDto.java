package greta.cda.bakeryproject.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateProductOrderDto {
    @NonNull
    private int unitPrice;

    @NonNull
    private int quantity;

    @NonNull
    private Integer productId;
}
