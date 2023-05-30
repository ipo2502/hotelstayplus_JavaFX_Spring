package ieslapaloma.tfg.hotelstayplus.javafx.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class welcomeWindowController implements Initializable{
    
    @FXML
    private Button start_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start_btn.setOnAction(event -> onStart());
    }

    public void onStart() {
        System.out.println(start_btn.toString());
        Model.getInstance().getViewFactory().closedStage((Stage) start_btn.getScene().getWindow());
        Model.getInstance().getViewFactory().showLoginWindow();
    }

}
