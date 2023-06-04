package ieslapaloma.tfg.hotelstayplus.javafx.Controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ResourceBundle;

import com.github.javafaker.Book;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.javafx.Paths;
import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.ClientMenuOptions;
import ieslapaloma.tfg.hotelstayplus.model.Booking;
import ieslapaloma.tfg.hotelstayplus.model.Client;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import ieslapaloma.tfg.hotelstayplus.model.Service;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class BookingPageController implements Initializable {

    @FXML
    private ImageView backgroundImg_img;

    @FXML
    private ImageView bigImage1_img;

    @FXML
    private ImageView bigImage1_img1;

    @FXML
    private Label bigText2_lbl;

    @FXML
    private Label bigText_lbl;

    @FXML
    private Button booking_btn;

    @FXML
    private Button calculate_btn;

    @FXML
    private DatePicker datePicker1;

    @FXML
    private DatePicker datePicker2;

    @FXML
    private Label datesChosen_lbl;

    @FXML
    private FontAwesomeIconView heart_icon;

    @FXML
    private Label hotelName_lbl;

    @FXML
    private Label hotelName_lbl1;

    @FXML
    private Button like_btn;

    @FXML
    private Label location_lbl;

    @FXML
    private Label location_lbl2;

    @FXML
    private Label location_lbl21;

    @FXML
    private Label nRatings_lbl;

    @FXML
    private Label pricePerNight_lbl;

    @FXML
    private FontAwesomeIconView rating_icon;

    @FXML
    private Label ratingtitle_lbl;

    @FXML
    private Label ratingtitle_lbl1;

    @FXML
    private FontAwesomeIconView serv24h_icon;

    @FXML
    private Label serv24h_lbl;

    @FXML
    private FontAwesomeIconView servBar_icon;

    @FXML
    private Label servBar_lbl;

    @FXML
    private FontAwesomeIconView servDesayuno_icon;

    @FXML
    private Label servDesayuno_lbl;

    @FXML
    private FontAwesomeIconView servParking_icon;

    @FXML
    private Label servParking_lbl;

    @FXML
    private FontAwesomeIconView servWifi_icon;

    @FXML
    private Label servWifi_lbl;

    @FXML
    private ImageView stars_img;

    @FXML
    private Label totalPrice_lbl;

    @FXML
    private Label website_lbl;

    private static BookingPageController instance;
    private static LocalDate[] selectedDates = new LocalDate[2];
    private static boolean first = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        if (first) { //añadir que verifique que sea null cada uno de los elementos  del load data y borrar el if para que se actualicen
            loadData();
            first = false;
            calculate_btn.setOnAction(event -> onCalculate());
            booking_btn.setOnAction(event -> showConfirmationDialog());
        }  
    }

    public static BookingPageController getInstance() {
        return instance;
    }

    private void loadData() {
        datePicker1.setValue(null);
        datePicker2.setValue(null);

        Hotel hotel = Model.getInstance().getModelHotel();

        System.out.println(servDesayuno_icon.getOpacity());
        allServicesOpacity();

        List<Service> services = hotel.getServicesPojo();
        System.out.println(services.size());    
        //List<Service> servicesList = loadServices(services);
        //System.out.println("Está viendo e hotel: " +hotel+ " que tiene una lista de servicios de " +servicesList.toString());
        loadGraphicServices(services);

        String hotelUrlImg = Paths.getHotelUrlImage(hotel.getHotelImg_n());
        String bedroomUrlImg = Paths.getBedroomUrlImage(hotel.getHotelImg_n());
        String starsUrlImg = Paths.getHotelUrlImage((hotel.getStars()+6));
        System.out.println(starsUrlImg + " ---" +hotelUrlImg);
        //Image imageStars = new Image(getClass().getResourceAsStream(starsUrlImg));
        Image imageHotel = new Image(getClass().getResourceAsStream(hotelUrlImg));
        Image imageHotel2 = new Image(getClass().getResourceAsStream(starsUrlImg));

        Image imageBedroom = new Image(getClass().getResourceAsStream(bedroomUrlImg));

        String description1 = Paths.getDescription1(hotel.getDescription_n1(), hotel.getName());
        String description2 = Paths.getDescription2(hotel.getDescription_n2());

        hotelName_lbl.setText(hotel.getName());
        bigImage1_img.setImage(imageHotel);
        backgroundImg_img.setImage(imageHotel);
        //bigImage2_img.setImage(imageBedroom);
        pricePerNight_lbl.setText(hotel.getPrice()+"€/noche!");
        bigText_lbl.setText(description1);
        bigText2_lbl.setText(description2);
        website_lbl.setText(hotel.getWebsite());
        stars_img.setImage(imageHotel2);

    }

    private void showConfirmationDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure you want to proceed?");
        alert.setContentText("This action cannot be undone.");

        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");

        alert.getButtonTypes().setAll(yesButton, noButton);

        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == yesButton) {
                // User clicked "Yes"
                System.out.println("Confirmed");
                makeBooking();
            } else if (buttonType == noButton) {
                // User clicked "No"
                System.out.println("Cancelled");
            }
        });
    }

    private void makeBooking() {
        Hotel hotel = Model.getInstance().getModelHotel();
        Client client = Model.getInstance().getModelClient();
        Booking booking = new Booking(client, hotel, selectedDates[0], selectedDates[1]);
        try {
            DBManager.getInstance().getBookingService().addBooking(booking);
            Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.LOADING);
            //LoadingController.getInstance().initialize(null, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadGraphicServices(List<Service> services) {
        for (Service s : services) {
            switch(Math.toIntExact(s.getId())) {
                case 1:
                    servWifi_icon.setOpacity(100);
                    servWifi_lbl.setOpacity(100);
                    servWifi_icon.setFill(Color.valueOf("#80fa61"));
                    servWifi_lbl.setTextFill(Color.valueOf("#80fa61"));
                    break;
                case 2:
                    servBar_icon.setOpacity(100);
                    servBar_lbl.setOpacity(100);
                    servBar_icon.setFill(Color.valueOf("#80fa61"));
                    servBar_lbl.setTextFill(Color.valueOf("#80fa61"));
                    break;
                case 3:
                    servDesayuno_icon.setOpacity(100);
                    servDesayuno_lbl.setOpacity(100);
                    servDesayuno_icon.setFill(Color.valueOf("#80fa61"));
                    servDesayuno_lbl.setTextFill(Color.valueOf("#80fa61"));
                    break;
                case 4:
                    serv24h_icon.setOpacity(100);
                    serv24h_lbl.setOpacity(100);
                    serv24h_icon.setFill(Color.valueOf("#80fa61"));
                    serv24h_lbl.setTextFill(Color.valueOf("#80fa61"));
                    break;
                case 5:
                    servParking_icon.setOpacity(100);
                    servParking_lbl.setOpacity(100);
                    servParking_icon.setFill(Color.valueOf("#80fa61"));
                    servParking_lbl.setTextFill(Color.valueOf("#80fa61"));
                    break;
                default:
                    break;
            }
        }
    }

    private void allServicesOpacity() {
        servWifi_icon.setOpacity(0.57);
        servWifi_icon.setFill(Color.WHITE);
        servWifi_lbl.setOpacity(0.57);
        servWifi_lbl.setTextFill(Color.WHITE);
         
        servBar_icon.setOpacity(0.57);
        servBar_icon.setFill(Color.WHITE);
        servBar_lbl.setOpacity(0.57);
        servBar_lbl.setTextFill(Color.WHITE);

        servDesayuno_icon.setOpacity(0.57);
        servDesayuno_icon.setFill(Color.WHITE);
        servDesayuno_lbl.setOpacity(0.57);
        servDesayuno_lbl.setTextFill(Color.WHITE);

        serv24h_icon.setOpacity(0.57);
        serv24h_icon.setFill(Color.WHITE);
        serv24h_lbl.setOpacity(0.57);
        serv24h_lbl.setTextFill(Color.WHITE);

        servParking_icon.setOpacity(0.57);
        servParking_icon.setFill(Color.WHITE);
        servParking_lbl.setOpacity(0.57);
        servParking_lbl.setTextFill(Color.WHITE);
    }


    private void onCalculate() {
        System.out.println("oncalculate()");
        double price;
        String priceText = pricePerNight_lbl.getText();
        String numericText = priceText.replaceAll("[^\\d.]", ""); // Remove non-numeric characters
        try {
            price = Double.parseDouble(numericText);
        } catch (NumberFormatException e) {
            // Handle the case when the price cannot be parsed as a double
            price = 0.0; // Set a default value or handle the error as needed
        }
        
        LocalDate startDate = datePicker1.getValue();
        LocalDate endDate = datePicker2.getValue();
        int maxDays = 30;
        boolean dates = true;
        int daysBetween = 0;
        if(dates) {
            daysBetween = Math.toIntExact(ChronoUnit.DAYS.between(startDate, endDate));
            if (daysBetween < 1) {
                datesChosen_lbl.setText("Seleccione dos fechas válidas");
            } else if (daysBetween < maxDays) {
                datesChosen_lbl.setText(daysBetween + " noches");
                selectedDates[0] = startDate;
                selectedDates[1] = endDate;
                dates = false;
                double totalprice = price * daysBetween;
                String output = "€ " + totalprice;
                totalPrice_lbl.setText(output);
            }
            } else {
                datesChosen_lbl.setText("El hotel sólo permite residencias de " +maxDays);
    
            }
            System.out.println("bucle?");
        }
      
    
}
