package production.kpi.pojo.plane;

import com.vaadin.flow.spring.annotation.SpringComponent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import production.kpi.pojo.people.Worker;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
@SpringComponent
@EqualsAndHashCode
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double trustIndex;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Navy> planes;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Worker> workers;

    public Company(String name, Double trustIndex, List<Navy> planes, List<Worker> workers) {
        this.name = name;
        this.trustIndex = trustIndex;
        this.planes = planes;
        this.workers = workers;
    }

    public Company(String name, Double trustIndex) {
        this.name = name;
        this.trustIndex = trustIndex;
    }
}
