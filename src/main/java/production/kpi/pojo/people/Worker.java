package production.kpi.pojo.people;

import com.vaadin.flow.spring.annotation.SpringComponent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "workers")
@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SpringComponent
public class Worker extends Person {
    private String position;

    public Worker(String firstName, String lastName, String email, String password, String position) {
        super(firstName, lastName, email, password);
        this.position = position;
    }

    public Worker(int id, String firstName, String lastName, String email, String password, String position) {
        super(id, firstName, lastName, email, password);
        this.position = position;
    }
}
