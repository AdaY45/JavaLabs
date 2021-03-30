package production.pojo.people;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;
import production.pojo.plane.Navy;

import java.util.LinkedList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Component
public class Worker extends User {
    private int id;
    private final String firstName;
    private final String lastName;
    private final String position;
    private String email;
    private String password;
    private final List<Navy> planes = new LinkedList<>();



}
