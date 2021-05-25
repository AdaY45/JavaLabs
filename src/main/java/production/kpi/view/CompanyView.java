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
import production.kpi.pojo.plane.Company;
import production.kpi.view.post.ClientPostView;
import production.kpi.view.post.CompanyPostView;

@Route("/company")
public class CompanyView extends VerticalLayout {
    private final CompanyController companyController;
    private final TextField filter = new TextField("", "Type to filter");
    private final Button addNewBtn = new Button("Add new");
    private final HorizontalLayout horizontalLayout = new HorizontalLayout(filter, addNewBtn);
    final Grid<Company> grid;


    public CompanyView(CompanyController companyController) {
        this.companyController = companyController;
        this.grid = new Grid<>(Company.class);
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid);
        grid.setHeight("300px");
        grid.setColumns("id", "name", "trustIndex", "planes", "workers");
        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);

        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> showClients(e.getValue()));
        addNewBtn.addClickListener(e -> {
            UI.getCurrent().navigate(CompanyPostView.class);
        });
        showClients("");
    }

    void showClients(String filterText) {
        if (filterText.isEmpty()) {
            grid.setItems(companyController.findAll());
        }
        else {
            grid.setItems(companyController.findCompanyByTitle(filterText));
        }
    }
}
