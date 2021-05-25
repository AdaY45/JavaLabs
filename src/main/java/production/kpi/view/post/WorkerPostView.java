package production.kpi.view.post;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import production.kpi.controller.WorkerController;
import production.kpi.pojo.people.Worker;
import production.kpi.view.WorkerView;

@Route("/worker/post")
public class WorkerPostView extends VerticalLayout implements KeyNotifier {
    private final WorkerController workerController;
    private Worker worker = new Worker();
    TextField firstname = new TextField("First name");
    TextField lastname = new TextField("Last name");
    TextField email = new TextField("Email");
    Button save = new Button("Save", VaadinIcon.CHECK.create());
    HorizontalLayout actions = new HorizontalLayout(save);
    Binder<Worker> binder = new Binder<>(Worker.class);

    public WorkerPostView(WorkerController workerController) {
        this.workerController = workerController;
        add(firstname, lastname, email, actions);
        binder.bindInstanceFields(this);
        setSpacing(true);
        binder.setBean(worker);
        save.getElement().getThemeList().add("primary");
        addKeyPressListener(Key.ENTER, e -> save());
        save.addClickListener(e -> save());
        save.addClickListener(e -> {
            UI.getCurrent().navigate(WorkerView.class);
        });
        setVisible(true);
    }

    void save() {
        worker = binder.getBean();
        workerController.save(worker);
    }
}
