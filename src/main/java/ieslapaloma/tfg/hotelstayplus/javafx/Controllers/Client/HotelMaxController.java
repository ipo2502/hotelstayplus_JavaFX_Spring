package ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Client;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.javafx.Paths;
import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.ClientMenuOptions;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import ieslapaloma.tfg.hotelstayplus.model.Service;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class HotelMaxController implements Initializable{

    @FXML
    private ImageView backgroundImg_img;

    @FXML
    private ImageView bigImage1_img;

    @FXML
    private ImageView bigImage2_img;

    @FXML
    private Label bigText2_lbl;

    @FXML
    private Label bigText_lbl;

    @FXML
    private Button booking_btn;

    @FXML
    private Label hotelName_lbl;

    @FXML
    private ImageView imageSmall1_img;

    @FXML
    private ImageView imageSmall2_img;

    @FXML
    private ImageView imageSmall3_img;

    @FXML
    private ImageView imageSmall4_img;

    @FXML
    private ImageView imageSmall5_img;

    @FXML
    private Label location_lbl;

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
    private Label website_lbl;

    @FXML
    private Label username_lbl;

    static Long id;

    private List<Service> allServices = List.of(
        new Service(1L, "Wifi"), 
        new Service(2L, "Bar"), 
        new Service(3L, "Desayuno"), 
        new Service(4L, "24 Horas"), 
        new Service(5L, "Parking"));

    boolean red = false;
    static HotelMaxController instance;
    static Hotel hotel = Model.getInstance().getModelHotel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        bigText_lbl.setWrapText(true); // Enable text wrapping
        bigText2_lbl.setWrapText(true); // Enable text wrapping
        load();
        booking_btn.setOnAction(event -> onBooking());
    }
    
    private void load() {
        hotel = Model.getInstance().getModelHotel();
        id = hotel.getId();
        allServicesOpacity();
        username_lbl.setText(Model.getInstance().getModelClient().getName() + " " + Model.getInstance().getModelClient().getSurnames());
        List<Service> services = hotel.getServicesPojo();
        loadGraphicServices(services);

        Random r = new Random();
        String days = r.nextInt(1574) +678 + " valoraciones";
        nRatings_lbl.setText(days);
        Model.getInstance().getModelClient().setRatingString(days);
        String hotelUrlImg = Paths.getHotelUrlImage(hotel.getHotelImg_n());
        String bedroomUrlImg = Paths.getBedroomUrlImage(hotel.getHotelImg_n());
        String starsUrlImg = Paths.getStarsUrlImage((hotel.getStars()));
        Image imageHotel = new Image(getClass().getResourceAsStream(hotelUrlImg));
        Image imageHotel2 = new Image(getClass().getResourceAsStream(starsUrlImg));
        Image starsImage = new Image(getClass().getResourceAsStream(starsUrlImg));
        Image imageBedroom = new Image(getClass().getResourceAsStream(bedroomUrlImg));

        String description1 = Paths.getDescription1(hotel.getDescription_n1(), hotel.getName());
        String description2 = Paths.getDescription2(hotel.getDescription_n2());

        hotelName_lbl.setText(hotel.getName());
        bigImage1_img.setImage(imageHotel);
        backgroundImg_img.setImage(imageHotel);
        bigImage2_img.setImage(imageBedroom);
        pricePerNight_lbl.setText(hotel.getPrice()+"€/noche!");
        location_lbl.setText(hotel.getLocation() + ", " +hotel.getCity());
        bigText_lbl.setText(description1);
        bigText2_lbl.setText(description2);
        website_lbl.setText(hotel.getWebsite());
        stars_img.setImage(starsImage);
        setRating(hotel.getRating(), ratingtitle_lbl, rating_icon);

    }

    public static HotelMaxController getInstance() {
        return instance;
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

    

    private void onBooking() {
        Hotel hotel = Model.getInstance().getModelHotel();
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.BOOKINGHOTEL);
        Model.getInstance().setSelectedModelHotel(hotel);
        BookingPageController.getInstance().initialize(null, null);
    }

    private void setRating(Double rating, Label label, FontAwesomeIconView icon) {
        String output = "";
        boolean badrating = false;
        if (rating > 9) {
            output = "Excelente";
        } else if (rating > 7) {
            output = "Muy buena";
        } else if (rating > 6) {
            output = "Bien";
        } else if (rating > 5) {
            output = "Decente";
        } else if (rating < 5) {
            output = "Mala";
            badrating = true;
        }
        if(badrating) {
            rating_icon.setGlyphName("THUMBS_DOWN");

        } else {
            rating_icon.setGlyphName("THUMBS_UP");

        }
        label.setText(output + " ("+rating+")");
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
}
