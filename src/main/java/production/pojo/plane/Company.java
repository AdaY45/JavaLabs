package production.pojo.plane;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import production.pojo.people.Worker;

import java.util.List;

@Data
@AllArgsConstructor
@Component
public class Company {
    String name;
    int trustIndex;
    List<Navy> planes;
    List<Worker> workers;
}
