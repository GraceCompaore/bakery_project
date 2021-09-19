package greta.cda.bakeryproject.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Person implements Serializable {
    @Id
    @Column(length = 36)
    @org.hibernate.annotations.Type(type="uuid-char")
    private UUID id;

    @NonNull
    private String login;

    @NonNull
    private String password;

    @NonNull
    private String role;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Command> orderList;
}
