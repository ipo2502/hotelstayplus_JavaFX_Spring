package ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Client.BookingController;
import ieslapaloma.tfg.hotelstayplus.model.Booking;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class AdminBookingsController implements Initializable{

    public static AdminBookingsController instance;
    @FXML
    private GridPane hotelesGrid;

    @FXML
    private Label nHotels_lbl;
    private static Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        load();
    }

    private void load() {
        if (hotelesGrid == null) {
            System.out.println("null");

        } else {

        List<Booking> bookings = DBManager.getInstance().getBookingService().getAllBookings();
        nHotels_lbl.setText(bookings.size()+" hoteles");

        int column = 0;
        int row = 1;
        try {
            for (Booking booking: bookings) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/ieslapaloma/tfg/FXML/Client/booking.fxml"));
 
                pane = fxmlLoader.load();

                BookingController bookingController = fxmlLoader.getController();
                bookingController.setBookedLabelVisible();
                bookingController.setData(booking);
                //pane.setOnMouseClicked(event -> bookingController.handleItemClick(event));
                
                
                
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
