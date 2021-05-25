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
import production.kpi.pojo.people.Client;
import production.kpi.repository.ClientRepository;

@SpringComponent
@UIScope
public class ClientEditor extends VerticalLayout implements KeyNotifier {
    private final ClientRepository clientRepository;
    private Client client;

    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private TextField email = new TextField("Email");

    private Button save = new Button("Save", VaadinIcon.CHECK.create());
    private Button cancel = new Button("Cancel");
    private Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    private HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

    private Binder<Client> binder = new Binder<>(Client.class);
    @Setter
    private ChangeHandler changeHandler;

    public interface ChangeHandler {
        void onChange();
    }

    @Autowired
    public ClientEditor(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
        add(lastName, firstName, email, actions);
        binder.bindInstanceFields(this);
        setSpacing(true);

        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e -> save());
        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editClient(client));
        setVisible(false);
    }

    private void delete() {
        clientRepository.delete(client);
        changeHandler.onChange();
    }

    private void save() {
        clientRepository.save(client);
        changeHandler.onChange();
    }

    public final void editClient(Client c) {
        if (c == null) {
            setVisible(false);
            return;
        }
        if (c.getId() != null) {
            client = clientRepository.findById(c.getId()).orElse(c);
        }
        else {
            client = c;
        }
        binder.setBean(client);
        setVisible(true);
        lastName.focus();
    }


}
