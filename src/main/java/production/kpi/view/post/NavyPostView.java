package production.kpi.view.post;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import production.kpi.controller.NavyController;
import production.kpi.pojo.plane.Navy;
import production.kpi.view.NavyView;

@Route("/navy/post")
public class NavyPostView extends VerticalLayout implements KeyNotifier {
    private final NavyController navyController;
    private Navy navy = new Navy();
    private TextField model = new TextField("Model");
    private TextField status = new TextField("Status");
    private TextField cost = new TextField("Cost");
    private NumberField speed = new NumberField("Speed");

    Button save = new Button("Save", VaadinIcon.CHECK.create());
    HorizontalLayout actions = new HorizontalLayout(save);
    Binder<Navy> binder = new Binder<>(Navy.class);

    public NavyPostView(NavyController navyController) {
        this.navyController = navyController;
        add(model, status, cost, speed, actions);
        binder.bindInstanceFields(this);
        setSpacing(true);
        binder.setBean(navy);
        save.getElement().getThemeList().add("primary");
        addKeyPressListener(Key.ENTER, e -> save());
        save.addClickListener(e -> save());
        save.addClickListener(e -> {
            UI.getCurrent().navigate(NavyView.class);
        });
        setVisible(true);
    }

    void save() {
        navy = binder.getBean();
        navyController.save(navy);
    }
}
