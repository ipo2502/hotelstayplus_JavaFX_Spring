package ieslapaloma.tfg.hotelstayplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import ieslapaloma.tfg.hotelstayplus.javafx.App;
import ieslapaloma.tfg.hotelstayplus.javafx.lokuraControll;
import ieslapaloma.tfg.hotelstayplus.locura;

import javafx.application.Application;

@SpringBootApplication
//@ComponentScan("ieslapaloma.tfg.hotelstayplus.service") // Adjust the package name accordingly
public class HotelstayplusApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelstayplusApplication.class, args);
		lokuraControll lokuracont = lokuraControll.getInstance(null);
		Application.launch(App.class, args);

	}

}
