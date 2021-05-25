package production.kpi.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import production.kpi.controller.*;
import production.kpi.pojo.people.Worker;
import production.kpi.view.post.WorkerPostView;

@Route("/worker")
public class WorkerView extends VerticalLayout {
    private final WorkerController workerController;
    private final TextField filter = new TextField("", "Type to filter");
    private final Button addNewBtn = new Button("Add new");
    private final HorizontalLayout horizontalLayout = new HorizontalLayout(filter, addNewBtn);
    final Grid<Worker> grid;


    public WorkerView(WorkerController workerController) {
        this.workerController = workerController;
        this.grid = new Grid<>(Worker.class);
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid);
        grid.setHeight("300px");
        grid.setColumns("id", "firstName", "lastName", "email");
        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> showWorkers(e.getValue()));
        addNewBtn.addClickListener(e -> {
            UI.getCurrent().navigate(WorkerPostView.class);
        });
        showWorkers("");
    }

    void showWorkers(String filterText) {
        if (filterText.isEmpty()) {
            grid.setItems(workerController.findAll());
        }
        else {
            grid.setItems(workerController.findWorkerByLastname(filterText));
        }
    }
}
