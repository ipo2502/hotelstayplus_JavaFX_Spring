package ieslapaloma.tfg.hotelstayplus.javafx.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.model.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ClientProfileController implements Initializable{

    @FXML
    private TextField address_fld;

    @FXML
    private TextField email_fld;

    @FXML
    private Label nHotels_lbl;

    @FXML
    private TextField name_fld;

    @FXML
    private Label phone_lbl1;

    @FXML
    private TextField phonenumber_fld;

    @FXML
    private TextField surnames_fld;

    @FXML
    private Label usernameTitle_lbl;

    @FXML
    private Button edit_btn;

    @FXML
    private Button update_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        load();
        edit_btn.setOnAction(event -> onEdit());
        update_btn.setOnAction(event -> onUpdate());
    }

    private void onEdit() {
        update_btn.setVisible(true);
        email_fld.setDisable(false);
        name_fld.setDisable(false);
        phonenumber_fld.setDisable(false);
        surnames_fld.setDisable(false);
        address_fld.setDisable(false);
    }

    private void onUpdate() {
        
    }

    private void load() {
        System.out.println("Está logeado con: " +Model.getInstance().getModelClient().toString());
        update_btn.setVisible(false);
        Client client = Model.getInstance().getModelClient();
        usernameTitle_lbl.setText(client.getName() + " " +client.getSurnames());
        email_fld.setDisable(true);
        email_fld.setText(client.getEmail());

        name_fld.setDisable(true);
        name_fld.setText(client.getName());

        phonenumber_fld.setDisable(true);
        phonenumber_fld.setText(client.getPhoneNumber());

        surnames_fld.setDisable(true);
        surnames_fld.setText(client.getSurnames());

        address_fld.setDisable(true);
        address_fld.setText(client.getAddress());
    }
    
}
