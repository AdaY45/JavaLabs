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
import production.kpi.controller.OrderController;
import production.kpi.pojo.order.Order;
import production.kpi.view.NavyView;

@Route("/order/post")
public class OrderPostView extends VerticalLayout implements KeyNotifier {
    private final OrderController orderController;
    private Order order = new Order();
    private TextField status = new TextField("Status");

    Button save = new Button("Save", VaadinIcon.CHECK.create());
    HorizontalLayout actions = new HorizontalLayout(save);
    Binder<Order> binder = new Binder<>(Order.class);

    public OrderPostView(OrderController orderController) {
        this.orderController = orderController;
        add(status, actions);
        binder.bindInstanceFields(this);
        setSpacing(true);
        binder.setBean(order);
        save.getElement().getThemeList().add("primary");
        addKeyPressListener(Key.ENTER, e -> save());
        save.addClickListener(e -> save());
        save.addClickListener(e -> {
            UI.getCurrent().navigate(NavyView.class);
        });
        setVisible(true);
    }

    void save() {
        order = binder.getBean();
        orderController.save(order);
    }
}
