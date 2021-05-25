package production.kpi;

import com.vaadin.flow.spring.annotation.EnableVaadin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import production.kpi.controller.*;
import production.kpi.pojo.order.Order;
import production.kpi.pojo.people.Client;
import production.kpi.pojo.people.Role;
import production.kpi.pojo.people.User;
import production.kpi.pojo.people.Worker;
import production.kpi.pojo.plane.*;
import production.kpi.service.PlanePartService;
import production.kpi.service.RoleService;
import production.kpi.service.UserService;

import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableVaadin
public class KpiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KpiApplication.class, args);

        Client client = new Client("Zarichniy", "Oleg", "dfgdfg@gmail.com", "fdgdgfgd");
        Client client2 = new Client("Bogdanets", "Olexandr", "bogolex@gmail.com", "bog12345");
        Client client3 = new Client("Kochyba", "Olga", "koch34@gmail.com", "123456");
        Navy plane = new Navy("F/A-18E/F Super Hornet", "In service", "US$66.0 million",1915D);
        Navy plane2 = new Navy("E-2 Hawkeye", "In service", "US$176 million", 650D);
        Navy plane3 = new Navy("P-8 Poseidon", "In service", "US$256.5 million", 907D);
        Navy plane4 = new Navy("EA-18G Growler", "In service", "US$68.2 million", 1900D);
        Navy plane5 = new Navy("E-6 Mercury", "In service", "US$141.7 million", 980D);
        Navy plane6 = new Navy("P-8 Poseidon", "In service", "US$256.5 million", 907D);
        Navy plane7 = new Navy("F/A-18E/F Super Hornet", "In service", "US$66.0 million", 1915D);
        Navy plane8 = new Navy("E-2 Hawkeye", "In service", "US$176 million", 650D);
        Navy plane9 = new Navy("E-6 Mercury", "In service", "US$141.7 million", 980D);
        Navy plane10 = new Navy("EP-3", "Active", "US$36 million", 700D);
        Navy plane11 = new Navy("EA-18G Growler", "In service", "US$68.2 million", 1900D);
        Navy plane12 = new Navy("P-3 Orion", "Active", "US$36 million", 761D);

        List<Navy> planes = List.of(plane, plane2, plane3, plane4, plane5, plane6, plane7, plane8, plane9, plane10);

        Worker worker1 = new Worker("Zalizniy", "Dmytro", "Mechanic", "zaldm@gmail.com", "Zal1123456");
        Worker worker2 = new Worker("Golyb", "Olga", "Technician", "tech@gmail.com", "123456");
        List<Worker> workers = List.of(worker1, worker2);

        TypeOfWork type = new TypeOfWork(TypeOfWork.Type.REPARATION);
        TypeOfWork type1 = new TypeOfWork(TypeOfWork.Type.CONSTRUCTION);
        Order order1 = new Order(client, planes, type, 1, Order.OrderStatus.PENDING);
        Order order2 = new Order(client2, planes, type1, 2, Order.OrderStatus.CONFIRMED);
        Detail detail1 = new Detail("Wing", 2500.34, "F/A-18E/F Super Hornet");
        Detail detail2 = new Detail("Fuselage", 1500.34, "E-6 Mercury");
        Company company = new Company("Boeing", 9D, planes, workers);
        PlanePart part = new PlanePart(plane, 2, List.of(detail1, detail2));
        Role role = new Role(Role.RoleName.CLIENT);
        Role role1 = new Role(Role.RoleName.WORKER);

        User user = new User("user", "Test", "user", "password", Set.of(role));
        User user2 = new User("user2", "Test", "user2", "1111", Set.of(role1));

        ClientController clientController = context.getBean(ClientController.class);
        NavyController navyController = context.getBean(NavyController.class);
        CompanyController companyController = context.getBean(CompanyController.class);
        OrderController orderController = context.getBean(OrderController.class);
        WorkerController workerController = context.getBean((WorkerController.class));
        DetailController detailController = context.getBean(DetailController.class);
        PlanePartService planePartService = context.getBean(PlanePartService.class);
        RoleService roleService = context.getBean(RoleService.class);
        RegistrationController registrationController = context.getBean(RegistrationController.class);

        System.out.println(clientController.save(client));
        System.out.println(clientController.save(client2));
        System.out.println(clientController.save(client3));
        System.out.println(navyController.save(plane));
        System.out.println(navyController.save(plane2));
        System.out.println(navyController.save(plane3));
        System.out.println(navyController.save(plane4));
        System.out.println(navyController.save(plane5));
        System.out.println(navyController.save(plane6));
        System.out.println(navyController.save(plane7));
        System.out.println(navyController.save(plane8));
        System.out.println(navyController.save(plane9));
        System.out.println(navyController.save(plane10));
        System.out.println(navyController.save(plane11));
        System.out.println(navyController.save(plane12));
        System.out.println(companyController.save(company));
        System.out.println(orderController.save(order1));
        System.out.println(orderController.save(order2));
        System.out.println(workerController.save(worker1));
        System.out.println(detailController.save(detail1));
        System.out.println(detailController.save(detail2));
        System.out.println(planePartService.create(part));
        System.out.println(roleService.save(role));
        System.out.println(roleService.save(role1));
        System.out.println(registrationController.addUser(user));
        System.out.println(registrationController.addUser(user2));
    }

}
