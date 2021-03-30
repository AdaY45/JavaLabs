package production.pojo.plane;

import org.springframework.stereotype.Component;

@Component
public enum TypeOfWork {
    REPARATION("Reparation"), CONSTRUCTION("Construction");

    private final String title;

    TypeOfWork(String title) {
        this.title = title;
    }
}
