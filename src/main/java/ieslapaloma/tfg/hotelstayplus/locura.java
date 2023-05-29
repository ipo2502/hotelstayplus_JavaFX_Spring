package ieslapaloma.tfg.hotelstayplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ieslapaloma.tfg.hotelstayplus.javafx.Models.Client;
import ieslapaloma.tfg.hotelstayplus.repository.ClientRepository;
import ieslapaloma.tfg.hotelstayplus.service.ClientService;

import java.util.List;

@SpringBootApplication
public class locura {

    private final ClientRepository userRepository; // Assuming you have a UserRepository class

    private final ClientService userService; // Assuming you have a UserService class

    public locura(ClientRepository userRepository, ClientService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(locura.class, args);
        locura application = context.getBean(locura.class);
        application.run();
    }

    public void run() {
        List<Client> users = userRepository.findAll(); // Fetch all users from the repository
        System.out.println("------------------------------------------LA SIZE: " +users.size());
        for (Client u : users) {
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA"+ u.toString());
        }
        // Do something with the users
        //userService.doSomethingWithUsers(users); // Pass the users to the service for further processing
    }
}

