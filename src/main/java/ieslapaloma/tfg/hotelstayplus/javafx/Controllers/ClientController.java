package ieslapaloma.tfg.hotelstayplus.javafx.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class ClientController implements Initializable{

    public BorderPane client_parent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem()
            .addListener((observable, oldValue, newValue) -> {
                switch(newValue) {
                    case DASHBOARD -> client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
                    case BOOKINGS -> client_parent.setCenter(Model.getInstance().getViewFactory().getBookingsView());
                    case PROFILE -> client_parent.setCenter(Model.getInstance().getViewFactory().getProfileView());
                    //esto es una guarrada
                    case MAX -> client_parent.setCenter(Model.getInstance().getViewFactory().getMaxView());
                    case BOOKINGHOTEL -> client_parent.setCenter(Model.getInstance().getViewFactory().getHotelBookingView());
                    case LOADING -> client_parent.setCenter(Model.getInstance().getViewFactory().getLoadingView());
                    case SUCCESSFULBOOKING -> client_parent.setCenter(Model.getInstance().getViewFactory().getBookingSuccessfulView());
                    default -> client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
                    
                }
            });

    }
}
