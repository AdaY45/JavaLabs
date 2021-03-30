package production.pojo.people;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Role {
    private Integer id;
    private String name;

    public enum RoleName {
        CLIENT, WORKER
    }
}
