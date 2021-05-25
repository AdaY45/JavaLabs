package production.kpi.components;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import production.kpi.pojo.people.Worker;
import production.kpi.repository.WorkerRepository;

@SpringComponent
@UIScope
public class WorkerEditor extends VerticalLayout implements KeyNotifier {
    private final WorkerRepository workerRepository;
    private Worker worker;

    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private TextField email = new TextField("Email");

    private Button save = new Button("Save", VaadinIcon.CHECK.create());
    private Button cancel = new Button("Cancel");
    private Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    private HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

    private Binder<Worker> binder = new Binder<Worker>(Worker.class);
    @Setter
    private ClientEditor.ChangeHandler changeHandler;

    public interface ChangeHandler {
        void onChange();
    }

    @Autowired
    public WorkerEditor(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
        add(lastName, firstName, email, actions);
        binder.bindInstanceFields(this);
        setSpacing(true);

        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e -> save());
        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editWorker(worker));
        setVisible(false);
    }

    private void delete() {
        workerRepository.delete(worker);
        changeHandler.onChange();
    }

    private void save() {
        workerRepository.save(worker);
        changeHandler.onChange();
    }

    public final void editWorker(Worker w) {
        if (w == null) {
            setVisible(false);
            return;
        }
        if (w.getId() != null) {
            worker = workerRepository.findById(w.getId()).orElse(w);
        }
        else {
            worker = w;
        }
        binder.setBean(worker);
        setVisible(true);
        lastName.focus();
    }


}
