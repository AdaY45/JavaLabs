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
import production.kpi.pojo.plane.Detail;
import production.kpi.repository.DetailRepository;

@SpringComponent
@UIScope
public class DetailEditor extends VerticalLayout implements KeyNotifier {
    private final DetailRepository detailRepository;
    private Detail detail;

    private TextField description = new TextField("Description");
    private NumberField weight = new NumberField("Weight");
    private TextField model = new TextField("Model");
    private Button cancel = new Button("Cancel");
    private Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    private HorizontalLayout actions = new HorizontalLayout(delete);

    private Binder<Detail> binder = new Binder<>(Detail.class);
    @Setter
    private ChangeHandler changeHandler;

    public interface ChangeHandler {
        void onChange();
    }

    @Autowired
    public DetailEditor(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
        add(description, weight, model, actions);
        binder.bindInstanceFields(this);
        setSpacing(true);
        delete.getElement().getThemeList().add("error");

        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editDetail(detail));
        setVisible(false);
    }

    private void delete() {
        detailRepository.delete(detail);
        changeHandler.onChange();
    }

    public final void editDetail(Detail d) {
        if (d == null) {
            setVisible(false);
            return;
        }
        if (d.getId() != null) {
            detail = detailRepository.findById(d.getId()).orElse(d);
        }
        else {
            detail = d;
        }
        binder.setBean(detail);
        setVisible(true);
        description.focus();
    }
}
