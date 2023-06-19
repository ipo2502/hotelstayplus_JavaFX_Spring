package ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Admin;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.model.Booking;
import ieslapaloma.tfg.hotelstayplus.model.Client;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class AdminControllerDashboard implements Initializable{

    @FXML
    private Label nHotels_lbl;

    @FXML
    private Label nHotels_lbl2;

    @FXML
    private Label nHotels_lbl21;

    @FXML
    private Label nUsers_lbl;

    @FXML
    private Label nbookings_lbl;

    @FXML
    private Label totalMoney_lbl;




    static List <Booking> bookings = DBManager.getInstance().getBookingService().getAllBookings();
    static List <Hotel> hotels = DBManager.getInstance().getHotelService().getAllHotels();
    static List <Client> clients = DBManager.getInstance().getClientService().getAllClients();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        load();
        
    }

    private void load(){


        double totalPriceSum = bookings.stream()
        .mapToDouble(Booking::getTotalPrice)
        .sum();
        totalMoney_lbl.setText("Se ha traspasado un total de €" +totalPriceSum);
        nbookings_lbl.setText(String.valueOf(bookings.size() + " reservas"));
        nHotels_lbl.setText(String.valueOf(hotels.size()) + " hoteles");
        nUsers_lbl.setText(String.valueOf(clients.size())+ " usuarios");
    }
    
}
