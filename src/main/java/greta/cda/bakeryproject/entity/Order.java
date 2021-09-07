package greta.cda.bakeryproject.entity;

import com.sun.tools.javac.util.List;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
@Data
public class Order {
    @Id
    private Integer id;
    private Date OrderAt;

    @OneToOne
   private Person person;

    }
