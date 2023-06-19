package ieslapaloma.tfg.hotelstayplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import ieslapaloma.tfg.hotelstayplus.javafx.App;

import javafx.application.Application;

@SpringBootApplication
@ComponentScan("ieslapaloma.tfg.hotelstayplus.service") // Adjust the package name accordingly
@ComponentScan("ieslapaloma.tfg.hotelstayplus.Models") // Adjust the package name accordingly
@ComponentScan("ieslapaloma.tfg.hotelstayplus.repository") // Adjust the package name accordingly

public class HotelstayplusApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(HotelstayplusApplication.class, args);
		Application.launch(App.class, args);

	}

	

}
