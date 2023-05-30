package ieslapaloma.tfg.hotelstayplus.javafx;
import java.lang.System.Logger;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.ClientMenuOptions;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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


        @FXML
        public void handleItemClick(MouseEvent event) {
            String title = hotelName.getText();
            String location = hotelLocation.getText();
            System.out.println("Clicked item: " + title + ", " + location);
            // Perform further actions with the clicked item information

            Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.MAX);


        }

    public void setData(Hotel hotel) {

        String url  = Paths.getImg(PathEnum.IMG_ICON, getClass()).toString();
        Image image = new Image(url);
        if (image == null) System.out.println("no");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        hotelLayout.setBackground(background);

        //Image image2 = new Image(getClass().getResourceAsStream(hotel.getImageSrc()));
       // Image image3 = new Image(getClass().getResourceAsStream(hotel.getBackgroundImg()));
        //hotelImage.setImage(image2);
        //background_img.setImage(image3);
       
        ///ieslapaloma/tfg/Images/hotel_sample.jpg
        String urlImg = getUrlimg(hotel.getImg_n());

        Image imageCover = new Image(getClass().getResourceAsStream(urlImg));
        hotelImage.setImage(imageCover);
        background_img.setImage(imageCover);

        hotelName.setText(hotel.getName());
        hotelLocation.setText(hotel.getLocation());

        //Image stars = new Image(getClass().getResourceAsStream(hotel.getStarsSrc()));
       // starsImage.setImage(stars);

        Random r = new Random();
        /*hotelBox.setStyle("-fx-background-color: #" +(colors[r.nextInt(colors.length)])
        + ";" +
        "-fx-background-radius: 10;"+
        "-fx-effect: dropShadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 10);");
        */
    }

    public String getUrlimg(int img_n) {
        switch(img_n) {
            case 1: return "/ieslapaloma/tfg/Images/hotel_sample.jpg";
            case 2: return "/ieslapaloma/tfg/Images/hotel_sample2.jpg";
            case 3: return "/ieslapaloma/tfg/Images/hotel_sample3.jpg";
            case 4: return "/ieslapaloma/tfg/Images/hotel_sample4.jpg";
            case 5: return "/ieslapaloma/tfg/Images/hotel_sample5.jpg";
            case 6: return "/ieslapaloma/tfg/Images/hotel_sample6.jpg";
            default: return "";
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    
}