package ieslapaloma.tfg.hotelstayplus.javafx.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import ieslapaloma.tfg.hotelstayplus.javafx.HotelController;
import ieslapaloma.tfg.hotelstayplus.javafx.Paths;
import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
    private Button like_btn;

    @FXML
    private Label location_lbl;

    @FXML
    private Label nRatings_lbl;

    @FXML
    private Label pricePerNight_lbl;

    @FXML
    private Label ratingtitle_lbl;

    @FXML
    private ImageView stars_img;

    @FXML
    private FontAwesomeIconView rating_icon;

    @FXML
    private Label website_lbl;

    @FXML
    private FontAwesomeIconView heart_icon;
    boolean red = false;
    static HotelMaxController instance;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        bigText_lbl.setWrapText(true); // Enable text wrapping
        bigText2_lbl.setWrapText(true); // Enable text wrapping
        //bigText_lbl.setText("El Hotel Paradise es un lujoso refugio situado en la hermosa costa de una isla paradisíaca. Con su arquitectura moderna y elegante, este hotel de cinco estrellas ofrece a sus huéspedes una experiencia inigualable de comodidad y lujo.");
        //bigText2_lbl.setText("Ubicado en un entorno idílico, rodeado de exuberantes jardines tropicales y con vistas impresionantes al océano, el Hotel Paradise combina a la perfección la belleza natural con las comodidades modernas.");
        load();
        like_btn.setOnAction(event -> onLike());
        booking_btn.setOnAction(event -> onBooking());
    }
    
    private void load() {
        System.out.println("EJECUCION DEL LOAD -------------------------------------------------------");
        Hotel hotel = Model.getInstance().getModelHotel();
        System.out.println("Está viendo e hotel: " +hotel);
        
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
        bigImage2_img.setImage(imageBedroom);
        pricePerNight_lbl.setText(hotel.getPrice()+"€/noche!");
        location_lbl.setText(hotel.getLocation());
        bigText_lbl.setText(description1);
        bigText2_lbl.setText(description2);
        website_lbl.setText(hotel.getWebsite());
        stars_img.setImage(imageHotel2);
        setRating(hotel.getRating(), ratingtitle_lbl, rating_icon);
    }

    public static HotelMaxController getInstance() {
        return instance;
    }

    private void onLike() {
        System.out.println(like_btn.toString());
        if (!red) {
            heart_icon.setFill(Color.valueOf("FF00009e")); //heartIcon.setFill(Color.RED);
            red = true;
        } else {
            heart_icon.setFill(Color.valueOf("ffffff8e")); //heartIcon.setFill(Color.RED);
            red = false;
        }

    }

    private void onBooking() {
        System.out.println(booking_btn.toString());
    }

    private void setRating(Double rating, Label label, FontAwesomeIconView icon) {
        String output = "";
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
            rating_icon.setGlyphName("THUMBS_DOWN");
        }
        label.setText(output);
    }
    
}
