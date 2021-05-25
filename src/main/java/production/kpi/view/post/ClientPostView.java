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
import production.kpi.controller.ClientController;
import production.kpi.pojo.people.Client;
import production.kpi.view.DetailView;

@Route("/client/post")
public class ClientPostView extends VerticalLayout implements KeyNotifier {
    private final ClientController clientController;
    private Client client = new Client();
    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private TextField email = new TextField("Email");
    Button save = new Button("Save", VaadinIcon.CHECK.create());
    HorizontalLayout actions = new HorizontalLayout(save);
    Binder<Client> binder = new Binder<>(Client.class);

    public ClientPostView(ClientController clientController) {
        this.clientController = clientController;
        add(firstName, lastName, email, actions);
        binder.bindInstanceFields(this);
        setSpacing(true);
        binder.setBean(client);
        save.getElement().getThemeList().add("primary");
        addKeyPressListener(Key.ENTER, e -> save());
        save.addClickListener(e -> save());
        save.addClickListener(e -> {
            UI.getCurrent().navigate(DetailView.class);
        });
        setVisible(true);
    }

    void save() {
        client = binder.getBean();
        clientController.save(client);
    }
}
