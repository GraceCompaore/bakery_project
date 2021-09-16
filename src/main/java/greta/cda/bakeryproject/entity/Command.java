package greta.cda.bakeryproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Command implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne
    private Person user;

    @OneToMany(fetch = FetchType.LAZY)
    private List<ProductOrder> productOrder;
}