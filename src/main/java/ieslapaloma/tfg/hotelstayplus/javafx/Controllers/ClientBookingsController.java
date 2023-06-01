package ieslapaloma.tfg.hotelstayplus.javafx.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.javafx.HotelController;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ClientBookingsController implements Initializable{

    @FXML
    private GridPane hotelesGrid;

    @FXML
    private Label nHotels_lbl;
    private static Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

        private void load() {
            if (hotelesGrid == null) {
                System.out.println("nulleooo");
    
            } else {
    
                        System.out.println("BDFDBDF:" +DBManager.getInstance().getHotelService().getAllHotels().get(0).toString());
            
            List<Hotel> hotelitos = DBManager.getInstance().getHotelService().getAllHotels();
            nHotels_lbl.setText(hotelitos.size()+" hoteles");
    
            int column = 0;
            int row = 1;
            try {
                for (Hotel hotel: hotelitos) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/ieslapaloma/tfg/FXML/Client/hotel2.fxml"));
     
                    pane = fxmlLoader.load();
    
                    HotelController hotelController = fxmlLoader.getController();
                    hotelController.setData(hotel);
                    pane.setOnMouseClicked(event -> hotelController.handleItemClick(event));
    
                    
                    
                        if (column == 1) {
                            column = 0;
                            ++row;
                        }
                        hotelesGrid.add(pane, column++, row);
                        GridPane.setMargin(pane, new Insets(10));
                    
    
                }
                
    
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
