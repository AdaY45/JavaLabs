package production.kpi.view;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import production.kpi.controller.*;
import production.kpi.pojo.plane.Detail;
import production.kpi.view.post.DetailPostView;

@Route("/detail")
public class DetailView extends VerticalLayout {
    private final DetailController detailController;
    private final TextField filter = new TextField("", "Type to filter");
    private final Button addNewBtn = new Button("Add new");
    private final HorizontalLayout horizontalLayout = new HorizontalLayout(filter, addNewBtn);
    final Grid<Detail> grid;
    private Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    private HorizontalLayout actions = new HorizontalLayout(delete);

    public DetailView(DetailController detailController) {
        this.detailController = detailController;
        this.grid = new Grid<>(Detail.class);
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid);
        grid.setHeight("300px");
        grid.setColumns("id", "description", "weight", "model");
        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> showDetails(e.getValue()));
        addNewBtn.addClickListener(e -> {
            UI.getCurrent().navigate(DetailPostView.class);
        });
        showDetails("");
    }

    void showDetails(String filterText) {
        if (filterText.isEmpty()) {
            grid.setItems(detailController.findAll());
        }
        else {
            grid.setItems(detailController.findDetailByTitle(filterText));
        }
    }
}

