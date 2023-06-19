package ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Client;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.model.Booking;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ClientBookingsController implements Initializable{

    public static ClientBookingsController instance;
    @FXML
    private GridPane hotelesGrid;

    @FXML
    private Label nHotels_lbl;
    private static Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        load();
    }

    public static ClientBookingsController getInstance() {
        return instance;
    }

        public void load() {
            if (hotelesGrid == null) {
                System.out.println("null");
    
            } else {
            hotelesGrid.getChildren().clear();
            Long id = Model.getInstance().getModelClient().getId();                
            List<Booking> bookings = DBManager.getInstance().getBookingService().getAllBookingsByClientId(id);
            nHotels_lbl.setText(bookings.size()+" hoteles");
    
            int column = 0;
            int row = 1;
            try {
                for (Booking booking: bookings) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/ieslapaloma/tfg/FXML/Client/booking.fxml"));
     
                    pane = fxmlLoader.load();
    
                    BookingController bookingController = fxmlLoader.getController();
                    bookingController.setData(booking);
                    pane.setOnMouseClicked(event -> bookingController.handleItemClick(event));
                    
                    
                    
                        if (column == 1) {
                            column = 0;
                            ++row;
                        }
                        hotelesGrid.add(pane, column++, row);
                        
                        //GridPane.setMargin(pane, new Insets(3));
                    
    
                }
                
    
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
