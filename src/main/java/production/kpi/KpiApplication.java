package production.kpi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import production.kpi.controller.ClientController;
import production.kpi.controller.NavyController;
import production.kpi.pojo.people.Client;
import production.kpi.pojo.plane.Navy;
import production.kpi.service.ClientService;
import production.kpi.service.impl.ClientServiceImpl;

@SpringBootApplication
public class KpiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(KpiApplication.class, args);

        Client client = new Client("Zarichniy", "Oleg", "dfgdfg@gmail.com", "fdgdgfgd");
        Navy plane = new Navy("F/A-18E/F Super Hornet", "McDonnell Douglas", "In service", "US$66.0 million", 1915);

        ClientController clientController = context.getBean(ClientController.class);
        NavyController navyController = context.getBean(NavyController.class);

        System.out.println(clientController.save(client));
        System.out.println(navyController.save(plane));

    }



}
