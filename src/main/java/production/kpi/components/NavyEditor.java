package production.kpi.components;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import production.kpi.pojo.plane.Navy;
import production.kpi.repository.NavyRepository;

@SpringComponent
@UIScope
public class NavyEditor extends VerticalLayout implements KeyNotifier {
    private final NavyRepository navyRepository;
    private Navy navy;

    private TextField model = new TextField("Model");
    private TextField status = new TextField("Status");
    private TextField cost = new TextField("Cost");
    private NumberField speed = new NumberField("Speed");

    private Button save = new Button("Save", VaadinIcon.CHECK.create());
    private Button cancel = new Button("Cancel");
    private Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    private HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

    private Binder<Navy> binder = new Binder<>(Navy.class);
    @Setter
    private ChangeHandler changeHandler;

    public interface ChangeHandler {
        void onChange();
    }

    @Autowired
    public NavyEditor(NavyRepository navyRepository) {
        this.navyRepository = navyRepository;
        add(model, status, cost, speed, actions);
        binder.bindInstanceFields(this);
        setSpacing(true);

        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e -> save());
        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editNavy(navy));
        setVisible(false);
    }

    private void delete() {
        navyRepository.delete(navy);
        changeHandler.onChange();
    }

    private void save() {
        navyRepository.save(navy);
        changeHandler.onChange();
    }

    public final void editNavy(Navy n) {
        if (n == null) {
            setVisible(false);
            return;
        }
        if (n.getId() != null) {
            navy = navyRepository.findById(n.getId()).orElse(n);
        }
        else {
            navy = n;
        }
        binder.setBean(navy);
        setVisible(true);
        model.focus();
    }


}
