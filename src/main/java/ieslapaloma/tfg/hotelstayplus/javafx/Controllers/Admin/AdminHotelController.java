package ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class AdminHotelController implements Initializable{
    @FXML
    private GridPane hotelesGrid;
    private static GridPane hotelesGrid2;

    private static AdminHotelController instance;

    @FXML
    private Button addHotel_btn;

    @FXML
    private Label nHotels_lbl;
    private static Pane pane;
    static List<Hotel> hotels = DBManager.getInstance().getHotelService().getAllHotels();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        load();
        addHotel_btn.setOnAction(event -> onAddHotel());
    }

    
    private void onAddHotel() {
        if (hotelesGrid == null) {
            System.out.println("null");
            hotelesGrid = hotelesGrid2;
        }
        int column = 0;
        int row = 1;
        try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/ieslapaloma/tfg/FXML/Admin/hotelToAdd.fxml"));
 
                pane = fxmlLoader.load();                
                
                    if (column == 1) {
                        column = 0;
                        ++row;
                    }
                    hotelesGrid.add(pane, column++, row);
                    
                    //GridPane.setMargin(pane, new Insets(3));
                
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AdminHotelController getInstance() {
        return instance;
    }

    public void load() {
        hotels = DBManager.getInstance().getHotelService().getAllHotels();
        if (hotelesGrid == null) {
            System.out.println("null");

        } else {
            hotelesGrid.getChildren().clear();
        hotelesGrid2 = hotelesGrid;
        nHotels_lbl.setText(hotels.size() + " hoteles");
        int column = 0;
        int row = 1;
        try {
            for (Hotel hotel: hotels) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/ieslapaloma/tfg/FXML/Admin/hotelAdmin.fxml"));
 
                pane = fxmlLoader.load();

                AdminSingleHotelController hotelController = fxmlLoader.getController();
                hotelController.setData(hotel);
                //pane.setOnMouseClicked(event -> hotelController.handleItemClick(event));
                
                
                
                    if (column == 1) {
                        column = 0;
                        ++row;
                    }
                    hotelesGrid.add(pane, column++, row);
                    
                    //GridPane.setMargin(pane, new Insets(3));
                

            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    
}
