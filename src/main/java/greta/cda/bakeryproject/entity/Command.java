package greta.cda.bakeryproject.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Command implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NonNull
    private Date dateCommand;

    @NonNull
    @ManyToOne
    private Person user;

//    @NonNull
//    @OneToMany(fetch = FetchType.LAZY)
//    private List<ProductOrder> productOrder;
}