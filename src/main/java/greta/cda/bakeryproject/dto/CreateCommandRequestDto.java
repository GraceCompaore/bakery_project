package greta.cda.bakeryproject.dto;

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
