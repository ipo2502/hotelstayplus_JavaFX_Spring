package ieslapaloma.tfg.hotelstayplus.javafx.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import ieslapaloma.tfg.hotelstayplus.javafx.Models.Model;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ClientDashboardController implements Initializable{

    @FXML
    private Button dale_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dale_btn.setOnAction(event -> onButton());
    }

    public void onButton() {
        System.out.println(dale_btn.toString());
        Model.getInstance().getViewFactory().showOtherDashboardView();
    }
    
}
