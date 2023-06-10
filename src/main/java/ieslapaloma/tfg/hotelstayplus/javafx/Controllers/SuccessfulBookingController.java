package ieslapaloma.tfg.hotelstayplus.javafx.Controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.ClientMenuOptions;
import ieslapaloma.tfg.hotelstayplus.model.Booking;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class SuccessfulBookingController implements Initializable{
    @FXML
    private ImageView backgroundImg_img;

    @FXML
    private Label bookingNumber_lbl;

    @FXML
    private Button bookings_btn;

    @FXML
    private Label date1_lbl;

    @FXML
    private Label date2_lbl;

    @FXML
    private Label hotelName_lbl;

    @FXML
    private Label loading_lbl;

    @FXML
    private Label ratingtitle_lbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadData();
        bookings_btn.setOnAction(event -> onBookings());
    }

    private void onBookings() {
        System.out.println("a bookings");
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.BOOKINGS);
        ClientBookingsController        .getInstance().initialize(null, null);
    }

    private void loadData() {
        Booking booking = Model.getInstance().getModelBooking();

        LocalDate date1 = booking.getDateStart();
        LocalDate date2 = booking.getDateEnd();

        String stringDate1 = formatLocalDate(date1);
        String stringDate2 = formatLocalDate(date2);

        hotelName_lbl.setText(booking.getHotel().getName());
        bookingNumber_lbl.setText("Reserva HSPT"+booking.getBookingCode()); //cambiar esto a algo mejor
        date1_lbl.setText(stringDate1);
        date2_lbl.setText(stringDate2);
    }

    private String formatLocalDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM");
        String formattedDate = date.format(formatter);
    
        // Add the ordinal indicator for the day
        int dayOfMonth = date.getDayOfMonth();
        formattedDate = formattedDate.replace(Integer.toString(dayOfMonth), Integer.toString(dayOfMonth));
    
        return formattedDate;
    }

}
