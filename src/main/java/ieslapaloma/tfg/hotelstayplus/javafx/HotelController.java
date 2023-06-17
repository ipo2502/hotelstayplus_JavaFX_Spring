package ieslapaloma.tfg.hotelstayplus.javafx;
import java.lang.System.Logger;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.javafx.Controllers.HotelMaxController;
import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.ClientMenuOptions;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import ieslapaloma.tfg.hotelstayplus.model.Service;
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
    private Label id_lbl;

    HotelMaxController hotelMaxController;

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
            long id = Long.valueOf(id_lbl.getText());

            
            List<Service> services = DBManager.getInstance().getServiceService().getServicesByHotelId(id);
            System.out.println("SERVICES FROM HOTEL "+title+ " AND ID: "+id+" :::::: " +services.size());
            
            // Perform further actions with the clicked item information
            Hotel hotel = DBManager.getInstance().getHotelService().getHotelById(id).get();

            
            hotel.setRealPojoServices((services));

            System.out.println("**********hotel con id: " +hotel.getId());
            Model.getInstance().setSelectedModelHotel(hotel);
            Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.MAX);
            HotelMaxController.getInstance().initialize(null, null);

        }

    public void setData(Hotel hotel) {

        String url  = Paths.getImg(PathEnum.IMG_ICON, getClass()).toString();
        Image image = new Image(url);
        if (image == null) System.out.println("no");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        hotelLayout.setBackground(background);

        String urlImg = Paths.getHotelUrlImage(hotel.getHotelImg_n());
        String urlStarsImg = Paths.getStarsUrlImage((hotel.getStars()));

        Image imageCover = new Image(getClass().getResourceAsStream(urlImg));
        hotelImage.setImage(imageCover);
        background_img.setImage(imageCover);

        hotelName.setText(hotel.getName());
        hotelLocation.setText(hotel.getLocation());
        id_lbl.setText(String.valueOf(hotel.getId()));
        Image stars = new Image(getClass().getResourceAsStream(urlStarsImg));
        starsImage.setImage(stars);

        Random r = new Random();
        /*hotelBox.setStyle("-fx-background-color: #" +(colors[r.nextInt(colors.length)])
        + ";" +
        "-fx-background-radius: 10;"+
        "-fx-effect: dropShadow(three-pass-box, rgba(0,0,0,0.2), 10, 0, 0, 10);");
        */
    }
    //pasar esto a una clase
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    
}