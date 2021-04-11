package production.kpi.pojo.people;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.stereotype.Component;
import production.kpi.pojo.order.Order;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
public class Client extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToMany(mappedBy = "client", cascade = CascadeType.MERGE, orphanRemoval = true)
    private final List<Order> orders = new LinkedList<>();

    public Client(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
