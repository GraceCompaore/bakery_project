package greta.cda.bakeryproject.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Command implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    private Date dateCommand;

    @NonNull
    @ManyToOne
    private Person user;

    @NonNull
    @OneToMany(fetch = FetchType.LAZY)
    private List<ProductOrder> productOrder;
}