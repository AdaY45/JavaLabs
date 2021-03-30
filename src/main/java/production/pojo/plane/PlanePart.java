package production.pojo.plane;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@Component
public class PlanePart {
    private Integer id;
    private Navy plane;
    private Integer amount;
    private List<Detail> details;
}
