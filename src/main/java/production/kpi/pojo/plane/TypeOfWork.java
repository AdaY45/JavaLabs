package production.kpi.pojo.plane;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Component
@NoArgsConstructor
public class TypeOfWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Type title;

    public enum Type {
        REPARATION("Reparation"), CONSTRUCTION("Construction");

        private String title;

        Type(String title) {
            this.title = title;
        }
    }
}
