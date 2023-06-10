package ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.model.Booking;
import ieslapaloma.tfg.hotelstayplus.model.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class AdminUserController implements Initializable{

    @FXML
    private GridPane hotelesGrid;

    private static AdminUserController instance;

    @FXML
    private Button addUser_btn;

    @FXML
    private Label nHotels_lbl;
    private static Pane pane;
    static List<Client> clients = DBManager.getInstance().getClientService().getAllClients();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        load();
        addUser_btn.setOnAction(event -> onAddUser());
    }

    private void onAddUser() {
        int column = 0;
        int row = 1;
        try {
                Client client = new Client("Nuevo", "", "", "", 0, "", "", "");
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/ieslapaloma/tfg/FXML/Admin/userToAdd.fxml"));
 
                pane = fxmlLoader.load();

                AdminAddUserController userController = fxmlLoader.getController();
                //pane.setOnMouseClicked(event -> userController.handleItemClick(event));
                
                
                
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

    public static AdminUserController getInstance() {
        return instance;
    }

    public void load() {
        clients = DBManager.getInstance().getClientService().getAllClients();
        if (hotelesGrid == null) {
            System.out.println("nulleooo");

        } else {
            hotelesGrid.getChildren().clear();

        System.out.println("hay un total de " +clients.size()+ " usuarios");
        nHotels_lbl.setText(clients.size() + " usuarios");
        int column = 0;
        int row = 1;
        try {
            for (Client client: clients) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/ieslapaloma/tfg/FXML/Admin/user.fxml"));
 
                pane = fxmlLoader.load();

                AdminSingleUserController userController = fxmlLoader.getController();
                userController.setData(client);
                pane.setOnMouseClicked(event -> userController.handleItemClick(event));
                
                
                
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
