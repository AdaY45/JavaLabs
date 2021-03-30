package production;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import production.config.AppConfig;
import production.pojo.people.Client;
import production.service.*;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ClientService clientService = ctx.getBean(ClientService.class);
        CompanyService companyService = ctx.getBean(CompanyService.class);
        DetailService detailService = ctx.getBean(DetailService.class);
        NavyService navyService = ctx.getBean(NavyService.class);
        OrderService orderService = ctx.getBean(OrderService.class);
        OrderStatusService orderStatusService = ctx.getBean(OrderStatusService.class);
        PlanePartService planePartService = ctx.getBean(PlanePartService.class);
        RoleService roleService = ctx.getBean(RoleService.class);
        TypeOfWorkService typeOfWorkService = ctx.getBean(TypeOfWorkService.class);
        UserService userService = ctx.getBean(UserService.class);
        WorkerService workerService = ctx.getBean(WorkerService.class);
        clientService.save(new Client());
    }
}
