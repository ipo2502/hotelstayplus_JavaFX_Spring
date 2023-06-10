package ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Admin;

import java.net.URL;
import java.util.ResourceBundle;

import com.mysql.cj.callback.UsernameCallback;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.ClientMenuOptions;
import ieslapaloma.tfg.hotelstayplus.model.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AdminSingleUserController implements Initializable{

    @FXML
    private TextField address_fld;

    @FXML
    private ImageView backgroundImg_img;

    @FXML
    private TextField bookings_fld;

    @FXML
    private AnchorPane container;

    @FXML
    private Button delete_btn;

    @FXML
    private Button edit_btn;

    @FXML
    private TextField email_fld;

    @FXML
    private ImageView little_img;

    @FXML
    private TextField password_fld;

    @FXML
    private TextField phoneNumber_fld;

    @FXML
    private Label userName_lbl;

    @FXML
    private TextField user_fld;

    @FXML
    private Label id_lbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setData(Client client) {
        setAllDisable(true);

        int clientBookings = 0; //preguntar a la BD cuantos tiene 

        userName_lbl.setText(client.getName());
        email_fld.setText(client.getEmail());
        user_fld.setText(client.getUsername());
        phoneNumber_fld.setText(client.getPhoneNumber());
        bookings_fld.setText(String.valueOf(clientBookings));
        password_fld.setText(client.getPassword());
        address_fld.setText(client.getAddress());

        id_lbl.setText(String.valueOf(client.getId()));

        delete_btn.setOnAction(event -> onDelete());
        edit_btn.setOnAction(event -> onEdit());
    }

    private void onDelete() {
        Long id = Long.valueOf(id_lbl.getText());
        System.out.println("delete client with id" +id);
        DBManager.getInstance().getClientService().deleteClientById(id);
        AdminUserController.getInstance().initialize(null, null);
    }

    private void onEdit() {
        
    }

    private void setAllDisable(boolean b) {
        email_fld.setDisable(b);
        user_fld.setDisable(b);
        phoneNumber_fld.setDisable(b);
        bookings_fld.setDisable(b);
        password_fld.setDisable(b);
        address_fld.setDisable(b);
    }

/*
 * 
 */
    public void handleItemClick(MouseEvent event) {
        Long id = Long.valueOf(id_lbl.getText());
        Client client = DBManager.getInstance().getClientService().getClientById(id);
        Model.getInstance().setModelAdminClient(client);
        System.out.println("Selected client id " +id);
    }
     
}
