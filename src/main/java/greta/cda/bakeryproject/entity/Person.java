package greta.cda.bakeryproject.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Person implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(unique = true, nullable = false)
    private String login;

    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;
}
