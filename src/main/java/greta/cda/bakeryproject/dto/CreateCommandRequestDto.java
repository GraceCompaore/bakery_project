package greta.cda.bakeryproject.dto;

import greta.cda.bakeryproject.entity.Person;
import greta.cda.bakeryproject.entity.ProductOrder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class CreateCommandRequestDto {
    @NonNull
    private String userId;

    @NonNull
    private List<CreateProductOrderDto> productOrderList;


}
