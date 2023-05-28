package ieslapaloma.tfg.hotelstayplus.javafx;
import java.lang.System.Logger;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.javafx.Models.Hotel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class HotelController implements Initializable{

    @FXML
    private HBox hotelLayout;

    @FXML
    private Label hotelLocation;

    @FXML
    private Label hotelName;

    @FXML
    private ImageView hotelImage;

    @FXML
    private ImageView background_img;

    @FXML
    private ImageView starsImage;
    private String[] starsPaths = {
        "/ieslapaloma/tfg/Images/stars1.jpg",
        "/ieslapaloma/tfg/Images/stars2.jpg",
        "/ieslapaloma/tfg/Images/stars3.jpg",
        "/ieslapaloma/tfg/Images/stars4.jpg",
        "/ieslapaloma/tfg/Images/stars5.jpg"
    };


    private String[] colors = {"CCF1FF",
        "E0D7FF",
        "FB9AA8",
        "FFCCE1",
        "D7EEFF",
        "FAFFC7"};

    public void setData(Hotel hotel) {

        String url  = Paths.getImg(PathEnum.IMG_ICON, getClass()).toString();
        Image image = new Image(url);
        if (image == null) System.out.println("no");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        hotelLayout.setBackground(background);

        Image image2 = new Image(getClass().getResourceAsStream(hotel.getImageSrc()));
        Image image3 = new Image(getClass().getResourceAsStream(hotel.getBackgroundImg()));
        hotelImage.setImage(image2);
        background_img.setImage(image3);
        hotelName.setText(hotel.getPOJOname());
        hotelLocation.setText(hotel.getpOJOlocatioString());

        //Image stars = new Image(getClass().getResourceAsStream(hotel.getStarsSrc()));
       // starsImage.setImage(stars);

        Random r = new Random();
        /*hotelBox.setStyle("-fx-background-color: #" +(colors[r.nextInt(colors.length)])
        + ";" +
        "-fx-background-radius: 10;"+
        "-fx-effect: dropShadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 10);");
        */
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    
}