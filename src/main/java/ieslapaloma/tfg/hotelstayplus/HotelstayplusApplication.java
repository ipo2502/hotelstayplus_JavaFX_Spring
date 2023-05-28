package ieslapaloma.tfg.hotelstayplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ieslapaloma.tfg.hotelstayplus.javafx.App;
import javafx.application.Application;

@SpringBootApplication
public class HotelstayplusApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelstayplusApplication.class, args);
		Application.launch(App.class, args);

	}

}
