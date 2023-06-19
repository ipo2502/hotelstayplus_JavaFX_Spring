package ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Client;

import java.net.URL;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.ClientMenuOptions;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ClientMenuController implements Initializable{

    @FXML
    private Button bookings_btn;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private Button profile_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addListeners();
    }

    private void addListeners() {
        bookings_btn.setOnAction(event -> onBookings());
        dashboard_btn.setOnAction(event -> onDashboard());
        logout_btn.setOnAction(event -> onLogout());
        profile_btn.setOnAction(event -> onProfile());
    }


    private void onBookings() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.BOOKINGS);

    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.DASHBOARD);
    }

    private void onLogout() {
        Stage stage = (Stage) bookings_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closedStage(stage);
        Model.getInstance().setModelClient(null);
        Model.getInstance().setClientLoginSucessFlag(false);
        Model.getInstance().getViewFactory().showLoginWindow();
    }

    private void onProfile() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.PROFILE);

    }
    
}
