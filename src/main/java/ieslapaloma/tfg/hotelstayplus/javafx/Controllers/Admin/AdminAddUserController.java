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

public class AdminAddUserController implements Initializable{

    @FXML
    private TextField address_fld;

    @FXML
    private ImageView backgroundImg_img;

    @FXML
    private TextField bookings_fld;

    @FXML
    private AnchorPane container;

    @FXML
    private Label date1_lbl;

    @FXML
    private Label date1_lbl1;

    @FXML
    private Label date1_lbl11;

    @FXML
    private Label date1_lbl12;

    @FXML
    private Label date1_lbl13;

    @FXML
    private Label date1_lbl2;

    @FXML
    private Label date1_lbl21;

    @FXML
    private Label date1_lbl211;

    @FXML
    private Button addUser_btn;

    @FXML
    private TextField email_fld;

    @FXML
    private Label id_lbl;

    @FXML
    private ImageView little_img;

    @FXML
    private TextField name_fld;

    @FXML
    private TextField password_fld;

    @FXML
    private TextField phoneNumber_fld;

    @FXML
    private TextField surnames_fld;

    @FXML
    private Label userName_lbl;

    @FXML
    private TextField user_fld;

    static AdminAddUserController instance;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        bookings_fld.setDisable(true);
        addUser_btn.setOnAction(event -> onAdd());
    }

    public static AdminAddUserController getInstance() {
        return instance;
    }

    public void onAdd() {
        Client client = new Client();
        client.setUsername(user_fld.getText());
        client.setEmail(email_fld.getText());
        client.setName(name_fld.getText());
        client.setSurnames(surnames_fld.getText());
        client.setPassword(password_fld.getText());
        client.setAddress(address_fld.getText());
        client.setPhoneNumber(phoneNumber_fld.getText());
        DBManager.getInstance().getClientService().addClient(client);
        AdminUserController.getInstance().load();
    }

    


 
     
}
