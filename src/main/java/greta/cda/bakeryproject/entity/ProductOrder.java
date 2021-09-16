package greta.cda.bakeryproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductOrder  implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    private int unitPrice;

    private int quantity;

    @ManyToOne
    private Command command;

    @ManyToOne
    private Product product;
}
