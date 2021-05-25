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
import production.kpi.controller.CompanyController;
import production.kpi.pojo.plane.Company;
import production.kpi.view.CompanyView;
import production.kpi.view.DetailView;

@Route("/company/post")
public class CompanyPostView extends VerticalLayout implements KeyNotifier {
    private final CompanyController companyController;
    private Company company = new Company();
    private NumberField trustIndex = new NumberField("TrustIndex");
    private TextField name = new TextField("Name");
    Button save = new Button("Save", VaadinIcon.CHECK.create());
    HorizontalLayout actions = new HorizontalLayout(save);
    Binder<Company> binder = new Binder<>(Company.class);

    public CompanyPostView(CompanyController companyController) {
        this.companyController = companyController;
        add(name, trustIndex, actions);
        binder.bindInstanceFields(this);
        setSpacing(true);
        binder.setBean(company);
        save.getElement().getThemeList().add("primary");
        addKeyPressListener(Key.ENTER, e -> save());
        save.addClickListener(e -> save());
        save.addClickListener(e -> {
            UI.getCurrent().navigate(CompanyView.class);
        });
        setVisible(true);
    }

    void save() {
        company = binder.getBean();
        companyController.save(company);
    }
}
