package ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Client;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.Filters;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ClientDashboard implements Initializable{
        
    private static Pane pane;

    @FXML
    private Button filter_btn;

    @FXML
    private ChoiceBox<Filters> filter_selector;

    @FXML
    private List<Hotel> recentlyAdded;

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
                Collections.sort(hotelitos, Comparator.comparingLong(Hotel::getId));
                load();
            default:
                hotelitos = DBManager.getInstance().getHotelService().getAllHotels();
                load();
                break;

        }
     
            
        
    }

    private void load() {
        if (hotelesGrid == null) {
            System.out.println("null");

        } else {
            userName_lbl.setText(Model.getInstance().getModelClient().getName() + " " + Model.getInstance().getModelClient().getSurnames());        
        
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