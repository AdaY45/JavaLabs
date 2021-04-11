package production.kpi.pojo.plane;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import production.kpi.pojo.people.Worker;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String name;
    int trustIndex;

    @OneToMany
    List<Navy> planes;
    @OneToMany
    List<Worker> workers;
}
