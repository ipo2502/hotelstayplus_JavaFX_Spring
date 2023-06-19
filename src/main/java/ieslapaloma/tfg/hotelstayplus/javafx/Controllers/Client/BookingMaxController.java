package ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Client;

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
import ieslapaloma.tfg.hotelstayplus.javafx.Views.ClientMenuOptions;
import ieslapaloma.tfg.hotelstayplus.model.Booking;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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

    @FXML
    private Button realCancelBooking_btn;

    @FXML
    private ImageView   background_img;

    public static BookingMaxController instance;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        load();
        cancelBooking_btn.setOnAction(event -> onCancel());
        contact_btn.setOnAction(event -> onContact());
        realCancelBooking_btn.setOnAction(event -> onRealCancel());
    }

    private void onContact() {
                showAlert("Llame al número de teléfono (6463605568) o escriba al correo " +Model.getInstance().getModelHotel().getEmail()+ ".");
    }

    private void onCancel() {
        showAlert("Tenga en cuenta que si desea cancelar su reserva, es posible que no recupere su dinero.");
        realCancelBooking_btn.setVisible(true);
    }

    private void onRealCancel() {
        showConfirmationDialog();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Atención");
        alert.setHeaderText(null);
        alert.setContentText(message);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/ieslapaloma/tfg/Images/icon.png")));
        alert.showAndWait();
    }

    private void showConfirmationDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("¿Está completamente seguro de que quiere cancelar la reserva?");
        alert.setHeaderText("El hotel " +hotelName_lbl.getText()+ " no permite devoluciones");
        alert.setContentText("No hay marcha atrás.");
        //alert.getDialogPane().getStyleClass().add("alert");
Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/ieslapaloma/tfg/Images/icon.png")));    
        ButtonType yesButton = new ButtonType("Sí");
        ButtonType noButton = new ButtonType("No");

        alert.getButtonTypes().setAll(yesButton, noButton);

        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == yesButton) {
                onDelete();
            } 
        });
    }

    private void onDelete() {
        Long id = Model.getInstance().getModelBooking().getId();
        DBManager.getInstance().getBookingService().deleteBookingById(id);
        ClientBookingsController.getInstance().load();
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.BOOKINGS);

    }

    public static BookingMaxController getInstance() {
        return instance;
    }
    
    private void load() {
        realCancelBooking_btn.setVisible(false);
        Booking booking = Model.getInstance().getModelBooking();
        Hotel hotel = booking.getHotel();
        hotelName_lbl.setText(hotel.getName());
        hotelPayment_lbl.setText("El hotel "+hotel.getName() + " se responsabiliza de todos los pagos.");
        //phoneNumber_lbl.setText(hotel.getPhoneNumber()); //añadir phone number a hotel
        bookingN_lbl.setText(booking.getBookingCode()); //next time
        nightsN_lbl.setText(String.valueOf(booking.getNumbernights()));

        String urlImg = Paths.getHotelUrlImage(hotel.getHotelImg_n());

        Image imageCover = new Image(getClass().getResourceAsStream(urlImg));
        little_img.setImage(imageCover);
        background_img.setImage(imageCover);
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
