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
import production.kpi.controller.DetailController;
import production.kpi.pojo.plane.Detail;
import production.kpi.view.DetailView;

@Route("/detail/post")
public class DetailPostView extends VerticalLayout implements KeyNotifier {
    private final DetailController detailController;
    private Detail detail = new Detail();
    TextField description = new TextField("Description");
    NumberField weight = new NumberField("Weight");
    TextField model = new TextField("Model");
    Button save = new Button("Save", VaadinIcon.CHECK.create());
    HorizontalLayout actions = new HorizontalLayout(save);
    Binder<Detail> binder = new Binder<>(Detail.class);

    public DetailPostView(DetailController detailController) {
        this.detailController = detailController;
        add(description, weight, model, actions);
        binder.bindInstanceFields(this);
        setSpacing(true);
        binder.setBean(detail);
        save.getElement().getThemeList().add("primary");
        addKeyPressListener(Key.ENTER, e -> save());
        save.addClickListener(e -> save());
        save.addClickListener(e -> {
            UI.getCurrent().navigate(DetailView.class);
        });
        setVisible(true);
    }

    void save() {
        detail = binder.getBean();
        detailController.save(detail);
    }
}
