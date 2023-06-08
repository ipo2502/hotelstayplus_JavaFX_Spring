package ieslapaloma.tfg.hotelstayplus.javafx.Controllers;

import java.net.URL;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.javafx.Paths;
import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.model.Booking;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BookingMaxController implements Initializable{

    @FXML
    private Label VAT_lbl;

    @FXML
    private Label address_lbl;

    @FXML
    private Label bookingN_lbl;

    @FXML
    private Button cancelBooking_btn;

    @FXML
    private Label checkin_lbl;

    @FXML
    private Label checkout_lbl;

    @FXML
    private Button contact_btn;

    @FXML
    private Label endDay_lbl;

    @FXML
    private Label endMonth_lbl;

    @FXML
    private Label endWeekDay_lbl;

    @FXML
    private Label hotelName_lbl;

    @FXML
    private Label hotelName_lbl1;

    @FXML
    private Label hotelName_lbl11;

    @FXML
    private Label hotelPayment_lbl;

    @FXML
    private ImageView little_img;

    @FXML
    private Label nightsN_lbl;

    @FXML
    private Label phoneNumber_lbl;

    @FXML
    private Label priceRoom_lbl;

    @FXML
    private Label startDay_lbl;

    @FXML
    private Label startMonth_lbl;

    @FXML
    private Label startWeekDay_lbl;

    @FXML
    private Label totalPrice_lbl;

    @FXML
    private Label tourismFee_lbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        load();
    }
    
    private void load() {
        Booking booking = Model.getInstance().getModelBooking();
        Hotel hotel = booking.getHotel();
        hotelName_lbl.setText(hotel.getName());
        //phoneNumber_lbl.setText(hotel.getPhoneNumber()); //añadir phone number a hotel
        //bookingN_lbl.setText(booking.getBookingCode()); //next time
        nightsN_lbl.setText(String.valueOf(booking.getNumbernights()));

        String urlImg = Paths.getHotelUrlImage(hotel.getHotelImg_n());

        Image imageCover = new Image(getClass().getResourceAsStream(urlImg));
        little_img.setImage(imageCover);

        LocalDate startDate = booking.getDateStart();
        LocalDate endDate = booking.getDateEnd();

        int startDayOfMonth = startDate.getDayOfMonth();
        int endDayOfMonth = endDate.getDayOfMonth();

        startDay_lbl.setText(String.valueOf(startDayOfMonth));
        startMonth_lbl.setText(getMonth(startDate));

        endDay_lbl.setText(String.valueOf(endDayOfMonth));
        endMonth_lbl.setText(getMonth(endDate));

        startWeekDay_lbl.setText(getDayWeek(startDate));
        endWeekDay_lbl.setText(getDayWeek(endDate));

        percentages(booking.getTotalPrice());

        

    }

    private void percentages(Double price) {
        double percentage1 = 85.56;
        double percentage2 = 9.79;
        double percentage3 = 4.65;

        double result = (percentage1 / 100.0) * price;
        priceRoom_lbl.setText("€ "+String.valueOf(format(result)));
        result =  (percentage2 / 100.0) * price;
        VAT_lbl.setText("€ "+String.valueOf(format(result)));
        result =  (percentage3 / 100.0) * price;
        tourismFee_lbl.setText("€ "+String.valueOf(format(result)));
        totalPrice_lbl.setText("€ " +String.valueOf(price));
    }

    private String format(Double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        // Format the number to have two decimal places
        String formattedNumber = decimalFormat.format(number);
        return formattedNumber;
    }

    private String getMonth(LocalDate localDate) {
        // Create a formatter to extract the month from the LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", Locale.forLanguageTag("es"));

         // Format the LocalDate to obtain the month name in Spanish
        String monthName = localDate.format(formatter);

        // Convert month name to title case (optional)
        monthName = monthName.substring(0, 1).toUpperCase() + monthName.substring(1).toLowerCase();
        return monthName;
    }

    private String getDayWeek(LocalDate localDate) {
        // Get the day of the week in Spanish
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        TextStyle spanishStyle = TextStyle.FULL_STANDALONE;
        Locale spanishLocale = new Locale.Builder().setLanguage("es").setRegion("ES").build();
        String dayOfWeekSpanish = dayOfWeek.getDisplayName(spanishStyle, spanishLocale);
        return dayOfWeekSpanish;
    }
}
