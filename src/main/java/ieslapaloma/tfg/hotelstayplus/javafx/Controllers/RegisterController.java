package ieslapaloma.tfg.hotelstayplus.javafx.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.fasterxml.jackson.databind.deser.ValueInstantiator.Gettable;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.model.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class RegisterController implements Initializable{
    @FXML
    private CheckBox accept2_cbox;

    @FXML
    private CheckBox accept_cbox;

    @FXML
    private TextField address_fld;

    @FXML
    private TextField email_fld;

    @FXML
    private Label error_lbl1;

    @FXML
    private TextField localidad_fld;

    @FXML
    private TextField name_fld;

    @FXML
    private PasswordField passwordRE_fld;

    @FXML
    private PasswordField password_fld;

    @FXML
    private TextField phoneN_fld;

    @FXML
    private Button register_btn;

    @FXML
    private TextField surnames_fld;

    static List<Client> allClients = DBManager.getInstance().getClientService().getAllClients();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        error_lbl1.setVisible(false);
        register_btn.setOnAction(event -> onRegister());
    }

    private void onRegister() {
        if (checkeo()) {
            createUser();
            System.out.println("registro");

        } else {
            System.out.println("err");
        }
    }

    private void createUser() {
        Client client = new Client();
        client.setName(name_fld.getText());
        client.setEmail(email_fld.getText());
        client.setSurnames(surnames_fld.getText());
        client.setPhoneNumber(phoneN_fld.getText());
        client.setPassword(password_fld.getText());
        client.setImg_n(1);
        client.setAddress(address_fld.getText());
        client.setUsername(localidad_fld.getText());
        DBManager.getInstance().getClientService().addClient(client);
        System.out.println(DBManager.getInstance().getClientService().getAllClients().toString());
        Model.getInstance().getViewFactory().showLoginWindow();
        Stage stage = (Stage) error_lbl1.getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage2 = (Stage) alert.getDialogPane().getScene().getWindow();
        stage2.getIcons().add(new Image(getClass().getResourceAsStream("/ieslapaloma/tfg/Images/icon.png")));
        alert.setTitle("Registro completado");
        alert.setHeaderText("¡Ha sido dado de alta!");
        alert.setContentText("Enhorabuena! Ahora forma parte de HotelStay+. Inicie sesión con sus credenciales.");
        alert.show();
        Model.getInstance().getViewFactory().closedStage(stage);
    }

    private boolean checkeo() {
        //que la longitud no sea muy larga
        //que el nº d telefono sea válido
        // etc
        boolean output = true;
        if (!password_fld.getText().equals(passwordRE_fld.getText())) {
            error_lbl1.setText("Las contraseñas insertadas no son iguales");
            output = false;
        }
        if (!email_fld.getText().contains("@") || !email_fld.getText().contains(".com")){
            error_lbl1.setText("Introduzca un email válido");
            output = false;
        }
        if(!accept_cbox.isSelected() || !accept2_cbox.isSelected()) {
            error_lbl1.setText("Acepte los términos");
            output = false;
        }
      

        if(!existsUsername(localidad_fld.getText())) {
            error_lbl1.setText("El nombre de usuario ya existe");
            output = false;
        }
        if(!existsEmail(email_fld.getText())) {
            error_lbl1.setText("El correo se encuentra en uso");
            output = false;
        }if(!existsPhoneNumber(phoneN_fld.getText())) {
            error_lbl1.setText("El número de teléfono se encuentra en uso");
            output = false;
        }
        if (!output) {
            error_lbl1.setVisible(true);
        }
        return output;
    }

    private boolean existsUsername(String newUsername) {
        for (int i = 0; i < allClients.size(); i++) {
            if (allClients.get(i).getUsername().equals(newUsername)) {
                System.out.println("ya existe el usuario: " +newUsername);
                return false;
            }
        }
        return true;
    }

    private boolean existsPhoneNumber(String phoneNumber) {
        for (int i = 0; i < allClients.size(); i++) {
            if (allClients.get(i).getPhoneNumber().equals(phoneNumber)) {
                System.out.println("ya existe el phoneNumber: " +phoneNumber);
                return false;
            }
        }
        return true;
    }

    private boolean existsEmail(String email) {
        for (int i = 0; i < allClients.size(); i++) {
            if (allClients.get(i).getEmail().equals(email)) {
                System.out.println("ya existe el email: " +email);
                return false;
            }
        }
        return true;
    }
}
