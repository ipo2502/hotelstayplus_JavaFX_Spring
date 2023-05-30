package ieslapaloma.tfg.hotelstayplus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ieslapaloma.tfg.hotelstayplus.javafx.App;
import ieslapaloma.tfg.hotelstayplus.service.HotelService;
import javafx.application.Application;

@SpringBootApplication
public class DBManager {

    private static HotelService hotelService;
    private static DBManager instance;

    public DBManager(HotelService hotelService) {
        this.hotelService = hotelService;
        instance = this;
    }
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DBManager.class, args);
        DBManager application = context.getBean(DBManager.class);
        application.start();
        Application.launch(App.class, args);

    }

    public static DBManager getInstance() {
        return instance;
    }

    public HotelService getHotelService() {
        return hotelService;
    }

    private void start() {
        System.out.println("AAAAAAAAAAAAAAAA: " +hotelService.getAllHotels().size());
    }
}
