package production.pojo.plane;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class Detail {
    private String description;
    private Double weight;
    private String model;

}
