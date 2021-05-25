package production.kpi.pojo.plane;


import com.vaadin.flow.spring.annotation.SpringComponent;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parts")
@Data
@NoArgsConstructor
@SpringComponent
public class PlanePart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plane_id")
    private Navy plane;
    private Integer amount;
    @OneToMany
    private List<Detail> details;

    public PlanePart(Navy plane, Integer amount, List<Detail> details) {
        this.plane = plane;
        this.amount = amount;
        this.details = details;
    }
}
