package production.kpi.pojo.people;

import com.vaadin.flow.spring.annotation.SpringComponent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "clients")

@Data
@NoArgsConstructor
@SpringComponent
public class Client extends Person {

    public Client(String lastName, String firstName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    public Client(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    public Client(int id, String firstName, String lastName, String email, String password) {
        super(id, firstName, lastName, email, password);
    }
}
