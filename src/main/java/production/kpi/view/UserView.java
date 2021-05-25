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
import production.kpi.pojo.people.User;
import production.kpi.view.post.UserPostView;

@Route("/user")
public class UserView extends VerticalLayout {
    private final UserController userController;
    private final TextField filter = new TextField("", "Type to filter");
    private final Button addNewBtn = new Button("Add new");
    private final HorizontalLayout horizontalLayout = new HorizontalLayout(filter, addNewBtn);
    final Grid<User> grid;

    public UserView(UserController userController) {
        this.userController = userController;
        this.grid = new Grid<>(User.class);
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid);
        grid.setHeight("300px");
        grid.setColumns("id", "firstName", "lastName", "email", "password");
        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);

        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> showUsers(e.getValue()));
        addNewBtn.addClickListener(e -> {
            UI.getCurrent().navigate(UserPostView.class);
        });
        showUsers("");
    }

    void showUsers(String filterText) {
        if (filterText.isEmpty()) {
            grid.setItems(userController.findAll());
        }
        else {
            grid.setItems(userController.findUserByLastname(filterText));
        }
    }
}

