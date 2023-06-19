package ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Client;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.javafx.PathEnum;
import ieslapaloma.tfg.hotelstayplus.javafx.Paths;
import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.ClientMenuOptions;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import ieslapaloma.tfg.hotelstayplus.model.Service;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @FXML
        public void handleItemClick(MouseEvent event) {
            long id = Long.valueOf(id_lbl.getText());

            
            List<Service> services = DBManager.getInstance().getServiceService().getServicesByHotelId(id);
            
            // Perform further actions with the clicked item information
            Hotel hotel = DBManager.getInstance().getHotelService().getHotelById(id).get();

            
            hotel.setRealPojoServices((services));

            Model.getInstance().setSelectedModelHotel(hotel);
            Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.MAX);
            HotelMaxController.getInstance().initialize(null, null);

        }

    public void setData(Hotel hotel) {

        String url  = Paths.getImg(PathEnum.IMG_ICON, getClass()).toString();
        Image image = new Image(url);
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

    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    
}