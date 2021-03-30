package production.pojo.order;

import org.springframework.stereotype.Component;

@Component
public enum OrderStatus {
    PENDING("Pending"), CONFIRMED("Confirmed"), SHIPPED("Shipped"),
    DELIVERED("Delivered"), CANCELLED("Cancelled");

    private final String title;

    OrderStatus(String title) {
        this.title = title;
    }
}

