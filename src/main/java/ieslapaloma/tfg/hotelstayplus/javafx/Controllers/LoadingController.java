package ieslapaloma.tfg.hotelstayplus.javafx.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.javafx.Paths;
import ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Client.BookingPageController;
import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.ClientMenuOptions;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoadingController implements Initializable{

    @FXML
    private Label loading_lbl;
    private static LoadingController instance;

        @FXML
    private ImageView backgroundImg_img;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;

        String url = Paths.getHotelUrlImage(Model.getInstance().getModelHotel().getHotelImg_n());
        Image img = new Image(url);
        backgroundImg_img.setImage(img);

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

                // Update the label on the UI thread
                Platform.runLater(() -> loading_lbl.setText("cargando ."));
                Thread.sleep(700);

                Platform.runLater(() -> loading_lbl.setText("cargando . ."));
                Thread.sleep(500);

                Platform.runLater(() -> loading_lbl.setText("cargando . . ."));
                Thread.sleep(800);
            }

            // Loading is complete, go to the next screen
            if (Model.getInstance().getSuccessfulBookingFlag()) {
                Platform.runLater(this::goSuccessful);
            
            } else {
                Platform.runLater(this::goFailed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void goFailed() {
       Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.BOOKINGHOTEL);
       BookingPageController.getInstance().initialize(null, null);
    }

    private void goSuccessful() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.SUCCESSFULBOOKING);

    }
    
}
