package greta.cda.bakeryproject.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private int quantity;

    @NonNull
    private double unitPrice;

    @OneToMany(fetch = FetchType.LAZY)
    private List<ProductOrder> productOrderList;
}

