package ieslapaloma.tfg.hotelstayplus.javafx;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.lang.System.Logger;
import java.net.URL;
import java.security.spec.ECPrivateKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.javafx.Models.Hotel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Controller implements Initializable{

      @FXML
    //private HBox hotelLayout;
    private List<Hotel> recentlyAdded;
    private String[] starsPaths = {
        "/ieslpaloma/Images/stars1.png",
        "/estoyharto/Images/stars2.png",
        "/estoyharto/Images/stars3.png",
        "/estoyharto/Images/stars4.png",
        "/estoyharto/Images/stars5.png"
    };

    private String[] backgroundImgs = {
        "/ieslapaloma/tfg/Images/hotel_sample.jpg",
        "/ieslapaloma/tfg/Images/hotel_sample2.jpg",
        "/ieslapaloma/tfg/Images/hotel_sample3.jpg",
        "/ieslapaloma/tfg/Images/hotel_sample4.jpg",
        "/ieslapaloma/tfg/Images/hotel_sample5.jpg",
        "/ieslapaloma/tfg/Images/hotel_sample6.jpg"
    };
    @FXML
    private GridPane hotelesGrid;

    @FXML
    private Label nHotels_lbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        load();
        hotelesGrid.setOnMouseClicked(event -> onPrint());

    }

    private void load() {
        recentlyAdded = new ArrayList<>(recentlyAdded());

        nHotels_lbl.setText(recentlyAdded.size()+" hoteles");
        

        int column = 0;
        int row = 1;
        try {
            for (Hotel hotel: recentlyAdded) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/ieslapaloma/tfg/FXML/Client/hotel2.fxml"));
    
                Pane pane = fxmlLoader.load();
    
                HotelController hotelController = fxmlLoader.getController();
                hotelController.setData(hotel);

                if (column == 2) {
                    column = 0;
                    ++row;
                }
                hotelesGrid.add(pane, column++, row);
                GridPane.setMargin(pane, new Insets(10));
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onPrint() {
        System.out.println("Acceso a la vaina");
    }

    private List<Hotel> recentlyAdded() {
        List<Hotel> ls = new ArrayList<>();
        Random r = new Random();
        Hotel hotel = new Hotel();
        hotel.setName("Hotel Ignacio");
        hotel.setpOJOlocation("Madrid");
        hotel.setImageSrc("/ieslapaloma/tfg/Images/hotel_sample.jpg");
        hotel.setStarsSrc(starsPaths[r.nextInt(starsPaths.length)]);
        hotel.setBackgroundImg(backgroundImgs[r.nextInt(backgroundImgs.length)]);
        ls.add(hotel);

        Hotel hotel1 = new Hotel();
        hotel1.setName("Hotel Gonzalo Aguilera");
        hotel1.setpOJOlocation("Toledo");
        hotel1.setImageSrc("/ieslapaloma/tfg/Images/hotel_sample2.jpg"); 
        hotel1.setStarsSrc(starsPaths[r.nextInt(starsPaths.length)]);
        hotel1.setBackgroundImg(backgroundImgs[r.nextInt(backgroundImgs.length)]);
        ls.add(hotel1);

        Hotel hotel3 = new Hotel();
        hotel3.setName("Hotel Alejandro Hinojosa");
        hotel3.setpOJOlocation("Alicante)");
        hotel3.setImageSrc("/ieslapaloma/tfg/Images/hotel_sample3.jpg"); 
        hotel3.setStarsSrc(starsPaths[r.nextInt(starsPaths.length)]);
        hotel3.setBackgroundImg(backgroundImgs[r.nextInt(backgroundImgs.length)]);
        ls.add(hotel3);

        Hotel hotel4 = new Hotel();
        hotel4.setName("Hotel Juan Avilés");
        hotel4.setpOJOlocation("Madrid)");
        hotel4.setImageSrc("/ieslapaloma/tfg/Images/hotel_sample4.jpg"); 
        hotel4.setStarsSrc(starsPaths[r.nextInt(starsPaths.length)]);
        hotel4.setBackgroundImg(backgroundImgs[r.nextInt(backgroundImgs.length)]);
        ls.add(hotel4);

        Hotel hotel5 = new Hotel();
        hotel5.setName("Hotel Julio César");
        hotel5.setpOJOlocation("Barcelona)");
        hotel5.setImageSrc("/ieslapaloma/tfg/Images/hotel_sample5.jpg"); 
        hotel5.setStarsSrc(starsPaths[r.nextInt(starsPaths.length)]);
        hotel5.setBackgroundImg(backgroundImgs[r.nextInt(backgroundImgs.length)]);
        ls.add(hotel5);

        Hotel hotel6 = new Hotel();
        hotel6.setName("Hotel Elena Garibay");
        hotel6.setpOJOlocation("Valencia)");
        hotel6.setImageSrc("/ieslapaloma/tfg/Images/hotel_sample6.jpg"); 
        hotel6.setStarsSrc(starsPaths[r.nextInt(starsPaths.length)]);
        hotel6.setBackgroundImg(backgroundImgs[r.nextInt(backgroundImgs.length)]);
        ls.add(hotel6);

        /*Hotel hotel2 = new Hotel();
        hotel2.setName("Hotel Ignacio");
        hotel2.setLocation("Madrid Sur (Alkorkón)");
        hotel2.setImageSrc("hotel_sample.jpg");
        ls.add(hotel2);

        Hotel hotel3 = new Hotel();
        hotel3.setName("Hotel Ignacio");
        hotel3.setLocation("Madrid Sur (Alkorkón)");
        hotel3.setImageSrc("hotel_sample.jpg");
        ls.add(hotel3);*/

        return ls;
    }

    
}