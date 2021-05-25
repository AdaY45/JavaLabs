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
import production.kpi.pojo.plane.Navy;
import production.kpi.view.post.NavyPostView;

@Route("/navy")
public class NavyView extends VerticalLayout {
    private final NavyController navyController;
    private final TextField filter = new TextField("", "Type to filter");
    private final Button addNewBtn = new Button("Add new");
    private final HorizontalLayout horizontalLayout = new HorizontalLayout(filter, addNewBtn);
    final Grid<Navy> grid;

    public NavyView(NavyController navyController) {
        this.navyController = navyController;
        this.grid = new Grid<>(Navy.class);
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid);
        grid.setHeight("300px");
        grid.setColumns("id", "model", "status", "cost", "speed");
        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);

        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> showNavies(e.getValue()));
        addNewBtn.addClickListener(e -> {
            UI.getCurrent().navigate(NavyPostView.class);
        });
        showNavies("");
    }

    void showNavies(String filterText) {
        if (filterText.isEmpty()) {
            grid.setItems(navyController.findAll());
        }
        else {
            grid.setItems(navyController.findNavyByDescription(filterText));
        }
    }
}

