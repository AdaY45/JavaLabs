package production.kpi.pojo.people;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Person {

    public User(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> roles;

    public User(String firstName, String lastName, String email, String password, Set<Role> roles) {
        super(firstName, lastName, email, password);
        this.roles = roles;
    }
}
