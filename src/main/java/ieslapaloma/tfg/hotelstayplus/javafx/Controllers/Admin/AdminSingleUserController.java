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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
    private Rectangle rectangle;

    @FXML
    private Label id_lbl;

    boolean edit1 = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setData(Client client) {
        setAllDisable(true);
        bookings_fld.setDisable(true);
        password_fld.setDisable(true);
        int clientBookings = DBManager.getInstance().getBookingService().getNumberOfBookingsByClientId(client.getId()); //preguntar a la BD cuantos tiene 

        rectangle.setFill(getColor(client.getImg_n()));
        
        userName_lbl.setText(client.getName() + " " +client.getSurnames());
        email_fld.setText(client.getEmail());
        user_fld.setText(client.getUsername());
        phoneNumber_fld.setText(client.getPhoneNumber());
        bookings_fld.setText(String.valueOf(clientBookings));
        String password = "*".repeat(client.getPassword().length());
        password_fld.setText(password);
        address_fld.setText(client.getAddress());

        id_lbl.setText(String.valueOf(client.getId()));

        delete_btn.setOnAction(event -> onDelete());
        edit_btn.setOnAction(event -> onEdit());
    }

    private Color getColor(int img) {
        Color c = Color.ORANGE;
        switch(img) {
            case 1:
            break;
            case 2:
            c = Color.ALICEBLUE;
            break;
            case 3:
            c = Color.AZURE;
            break;
            case 4:
            c = Color.BLANCHEDALMOND;
            break;
            case 5:
            c = Color.BROWN;
            break;
            case 6:
            c = Color.CORAL;
            break;
            case 7:
            c = Color.DARKSALMON;
            break;
            case 8:
            c = Color.FUCHSIA;
            break;
            case 9:
            c = Color.GREEN;
            break;
            case 10:
            c = Color.INDIGO;
            break;
            case 11:
            c = Color.YELLOW;
            break;
            case 12:
            c = Color.VIOLET;
            break;

        }
        return c;
    }

    private void onDelete() {
        Long id = Long.valueOf(id_lbl.getText());
        DBManager.getInstance().getClientService().deleteClientById(id);
        AdminUserController.getInstance().load();
    }

    private void pulse() {
        if (edit1) {
            edit1 = false;
        } else {
            edit1 = true;
        }
    }

    private void onEdit() {
        pulse();
        if (edit1) {
            setAllDisable(false);
            edit_btn.setStyle("-fx-background-color: rgba(145, 255, 135, 0.788);");
            

        } else {
            edit_btn.setStyle("-fx-background-color: rgba(135, 143, 255, 0.788);");
            Client client = DBManager.getInstance().getClientService().getClientById(Long.valueOf(id_lbl.getText()));
            client.setUsername(user_fld.getText());
            client.setEmail(email_fld.getText());
            getPassword(client);
            client.setAddress(address_fld.getText());
            client.setPhoneNumber(phoneNumber_fld.getText());
            DBManager.getInstance().getClientService().updateClient(client);
            setAllDisable(true);

        }

    }

    private void getPassword(Client client) {
        if (!password_fld.getText().contains("*")) {
            client.setPassword(password_fld.getText());
        }
    }

    private void setAllDisable(boolean b) {
        email_fld.setDisable(b);
        user_fld.setDisable(b);
        phoneNumber_fld.setDisable(b);
        address_fld.setDisable(b);
    }

/*
 * 
 */
    public void handleItemClick(MouseEvent event) {
        Long id = Long.valueOf(id_lbl.getText());
        Client client = DBManager.getInstance().getClientService().getClientById(id);
        Model.getInstance().setModelAdminClient(client);
    }
     
}
