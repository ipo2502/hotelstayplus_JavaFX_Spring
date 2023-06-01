package ieslapaloma.tfg.hotelstayplus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ieslapaloma.tfg.hotelstayplus.javafx.App;
import ieslapaloma.tfg.hotelstayplus.repository.BookingRepository;
import ieslapaloma.tfg.hotelstayplus.service.BookingService;
import ieslapaloma.tfg.hotelstayplus.service.ClientService;
import ieslapaloma.tfg.hotelstayplus.service.HotelService;
import ieslapaloma.tfg.hotelstayplus.service.ServiceService;
import javafx.application.Application;

@SpringBootApplication
public class DBManager {

    private static HotelService hotelService;
    private static ClientService clientService;
    private static ServiceService serviceService;
    private static BookingService bookingService;


    private static DBManager instance;

    public DBManager(HotelService hotelService, ClientService clientService, ServiceService serviceService, BookingService bookingService) {
        this.hotelService = hotelService;
        this.clientService = clientService;
        this.serviceService = serviceService;
        this.bookingService = bookingService;
        instance = this;
    }
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DBManager.class, args);
        DBManager application = context.getBean(DBManager.class);
        Application.launch(App.class, args);
    }

    public static DBManager getInstance() {
        return instance;
    }

    public HotelService getHotelService() {
        return hotelService;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public ServiceService getServiceService() {
        return serviceService;
    }

    public BookingService getBookingService() {
        return bookingService;
    }

}
