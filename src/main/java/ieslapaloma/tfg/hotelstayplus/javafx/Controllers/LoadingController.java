package ieslapaloma.tfg.hotelstayplus.javafx.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.ClientMenuOptions;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class LoadingController implements Initializable{

    @FXML
    private Label loading_lbl;
    private static LoadingController instance;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        System.out.println("loading las vainas");

  // Start the loading process in a separate thread
  Thread loadingThread = new Thread(this::load);
  loadingThread.start();

        //load();
        //goSuccessful();
    }

    public static LoadingController getInstance() {
        return instance;
    }

    private void load() {
        try {
            for (int i = 0; i < 2; i++) {
                System.out.println("vuelta: " + i);

                // Update the label on the UI thread
                Platform.runLater(() -> loading_lbl.setText("cargando ."));
                Thread.sleep(500);

                Platform.runLater(() -> loading_lbl.setText("cargando . ."));
                Thread.sleep(500);

                Platform.runLater(() -> loading_lbl.setText("cargando . . ."));
                Thread.sleep(500);
            }

            // Loading is complete, go to the next screen
            Platform.runLater(this::goSuccessful);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void goSuccessful() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.SUCCESSFULBOOKING);

    }
    
}
