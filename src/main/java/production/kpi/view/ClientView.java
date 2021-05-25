package production.kpi.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import production.kpi.components.ClientEditor;
import production.kpi.controller.*;
import production.kpi.pojo.people.Client;
import production.kpi.view.post.ClientPostView;
import production.kpi.view.post.WorkerPostView;

@Route("/client")
public class ClientView extends VerticalLayout {
    private final ClientController clientController;
    private final TextField filter = new TextField("", "Type to filter");
    private final Button addNewBtn = new Button("Add new");
    private final HorizontalLayout horizontalLayout = new HorizontalLayout(filter, addNewBtn);
    final Grid<Client> grid;


    public ClientView(ClientController clientController) {
        this.clientController = clientController;
        this.grid = new Grid<>(Client.class);
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid);
        grid.setHeight("300px");
        grid.setColumns("id", "firstName", "lastName", "email");
        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);

        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> showClients(e.getValue()));
        addNewBtn.addClickListener(e -> {
            UI.getCurrent().navigate(ClientPostView.class);
        });
        showClients("");
    }

    void showClients(String filterText) {
        if (filterText.isEmpty()) {
            grid.setItems(clientController.findAll());
        }
        else {
            grid.setItems(clientController.findClientByLastname(filterText));
        }
    }
}
