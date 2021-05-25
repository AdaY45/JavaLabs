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
import production.kpi.controller.RegistrationController;
import production.kpi.pojo.people.User;
import production.kpi.view.UserView;

import javax.annotation.PostConstruct;

@Route("/register")
public class UserPostView extends VerticalLayout implements KeyNotifier {
    private final RegistrationController registrationController;
    private VerticalLayout layout = new VerticalLayout();
    private User user = new User();
    TextField firstname = new TextField("First name");
    TextField lastname = new TextField("Last name");
    TextField email = new TextField("Email");
    TextField password = new TextField("Password");
    Button save = new Button("Register", VaadinIcon.CHECK.create());
    HorizontalLayout actions = new HorizontalLayout(save);
    Binder<User> binder = new Binder<>(User.class);

    public UserPostView(RegistrationController registrationController) {

        this.registrationController = registrationController;
        add(firstname, lastname, email, password, actions);
        binder.bindInstanceFields(this);
        setSpacing(true);
        binder.setBean(user);
        save.getElement().getThemeList().add("primary");
        addKeyPressListener(Key.ENTER, e -> save());
        save.addClickListener(e -> save());
        save.addClickListener(e -> {
            UI.getCurrent().navigate(UserView.class);
        });
        setVisible(true);
        layout.setSizeFull();
    }

    void save() {
        user = binder.getBean();
        registrationController.addUser(user);
    }
}
