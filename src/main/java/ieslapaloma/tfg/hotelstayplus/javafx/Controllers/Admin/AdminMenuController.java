package ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Admin;

import java.net.URL;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.ClientMenuOptions;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AdminMenuController implements Initializable{

    
    @FXML
    private Button bookings_btn;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button hotels_btn;

    @FXML
    private Button hotelstay_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private Button users_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addListeners();

    }

    private void addListeners() {
        bookings_btn.setOnAction(event -> onBookings());
        dashboard_btn.setOnAction(event -> onDashboard());
        logout_btn.setOnAction(event -> onLogOut());
        users_btn.setOnAction(event -> onUsers());
        hotelstay_btn.setOnAction(event -> onHSP());
        hotels_btn.setOnAction(event -> onHotels());
    }

    private void onBookings() {
        System.out.println("bookings");
    }
    private void onDashboard() {
        System.out.println("onDashboard");

    }private void onLogOut() {
        System.out.println("onLogOut");

    }private void onUsers() {
        System.out.println("onUsers");
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.ADMINUSER);


    }private void onHSP() {
        System.out.println("onHSP");
        
    }private void onHotels() {
        System.out.println("onHotels");
    }
    
}
