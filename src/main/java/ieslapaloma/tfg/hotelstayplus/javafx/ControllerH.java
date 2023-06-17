package ieslapaloma.tfg.hotelstayplus.javafx;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.lang.System.Logger;
import java.net.URL;
import java.security.spec.ECPrivateKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.HotelstayplusApplication;
import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.ClientMenuOptions;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.Filters;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import ieslapaloma.tfg.hotelstayplus.repository.ClientRepository;
import ieslapaloma.tfg.hotelstayplus.repository.HotelRepository;
import ieslapaloma.tfg.hotelstayplus.service.HotelService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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

import org.springframework.stereotype.Controller;

public class ControllerH implements Initializable{
    
    private HotelRepository hotelRepository;
   
    @Autowired
    private HotelService hotelService;
    private ObservableList<Hotel> hotelsList = FXCollections.observableArrayList();
    
    private Hotel hotelSelected;
    private static Pane pane;

    @FXML
    private Button filter_btn;

    @FXML
    private ChoiceBox<Filters> filter_selector;

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

    @FXML
    private Label userName_lbl;

    static List<Hotel> hotelitos = DBManager.getInstance().getHotelService().getAllHotels();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        load();
        filter_btn.setOnAction(event -> onFilter(hotelitos));
        filter_selector.setItems(FXCollections.observableArrayList(
            Filters.Recientes, Filters.Baratos, Filters.Caros, Filters.MenosEstrellas, Filters.MasEstrellas)
            );

        //nHotels_lbl.setText(String.valueOf(clientRepository.count()));
        //hotelesGrid.setOnMouseClicked(event -> onPrint());

    }

    private void onFilter(List<Hotel> collection) {
        switch(filter_selector.getValue()) {
            case MasEstrellas:
                Collections.sort(hotelitos, Comparator.comparingInt(Hotel::getStars).reversed());
                load();
                break;
            case MenosEstrellas:
                Collections.sort(hotelitos, Comparator.comparingInt(Hotel::getStars));
                load();
                break;
            case Caros:
                Collections.sort(hotelitos, Comparator.comparingDouble(Hotel::getPrice).reversed());
                load();
                break;
            case Baratos:
                Collections.sort(hotelitos, Comparator.comparingDouble(Hotel::getPrice));
                load();
                break;
            case Recientes:
                hotelitos = DBManager.getInstance().getHotelService().getAllHotels();
                Collections.reverse(hotelitos);
                load();
            default:
                hotelitos = DBManager.getInstance().getHotelService().getAllHotels();
                load();
                break;

        }
     
            
        
    }

    private void load() {
        if (hotelesGrid == null) {
            System.out.println("nulleooo");

        } else {
            userName_lbl.setText(Model.getInstance().getModelClient().getName() + " " + Model.getInstance().getModelClient().getSurnames());
        
        System.out.println("BDFDBDF:" +DBManager.getInstance().getHotelService().getAllHotels().get(0).toString());
        
        
        nHotels_lbl.setText(hotelitos.size()+" hoteles");

        int column = 0;
        int row = 1;
        try {
            for (Hotel hotel: hotelitos) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/ieslapaloma/tfg/FXML/Client/hotel2.fxml"));
 
                pane = fxmlLoader.load();

                HotelController hotelController = fxmlLoader.getController();
                hotelController.setData(hotel);
                pane.setOnMouseClicked(event -> hotelController.handleItemClick(event));

                
                
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
    }
    
}