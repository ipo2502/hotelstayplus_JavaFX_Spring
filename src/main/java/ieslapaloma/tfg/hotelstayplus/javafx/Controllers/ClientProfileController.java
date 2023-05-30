package ieslapaloma.tfg.hotelstayplus.javafx.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.model.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ClientProfileController implements Initializable{

    @FXML
    private Label email_lbl;

    @FXML
    private Label nHotels_lbl;

    @FXML
    private Label name_lbl;

    @FXML
    private Label phone_lbl;


    @FXML
    private Label usernameTitle_lbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        load();
    }

    private void load() {
        System.out.println("Está logeado con: " +Model.getInstance().getModelClient().toString());
        Client client = Model.getInstance().getModelClient();
        usernameTitle_lbl.setText(client.getName());
        email_lbl.setText(client.getEmail());
        name_lbl.setText(client.getName());
        phone_lbl.setText(String.valueOf(client.getPhoneNumber()));
    }
    
}
