package greta.cda.bakeryproject.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductOrder implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    private int unitPrice;

    @NonNull
    private int quantity;

    @ManyToOne
    private Command command;

    @NonNull
    @ManyToOne
    private Product product;
}
