package ieslapaloma.tfg.hotelstayplus.javafx.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.javafx.Models.Model;
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
                    default -> client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
                }
            });
    }
}
