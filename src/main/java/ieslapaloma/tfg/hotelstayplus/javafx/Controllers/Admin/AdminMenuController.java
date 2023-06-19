package ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Admin;

import java.net.URL;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.ClientMenuOptions;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.ADMINBOOKINGS);

    }
    private void onDashboard() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.ADMINDASHBOARD);


    }private void onLogOut() {
        Stage stage = (Stage) bookings_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().closedStage(stage);
        Model.getInstance().setModelClient(null);
        //Platform.exit();
        Model.getInstance().setClientLoginSucessFlag(false);
        Model.getInstance().getViewFactory().showLoginWindow();

    }private void onUsers() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.ADMINUSER);


    }private void onHSP() {
        showAlert("Esta aplicación ha sido desarrollada por Ignacio Pérez Ortega.");
        
    }private void onHotels() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.ADMINHOTELS);

    }

     private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("HotelStay+");
        alert.setHeaderText(null);
        alert.setContentText(message);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/ieslapaloma/tfg/Images/icon.png")));
        alert.showAndWait();
    }
    
}
