package ieslapaloma.tfg.hotelstayplus.javafx.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.AccountType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController implements Initializable{
    @FXML
    private ChoiceBox<AccountType> acc_selector;

    @FXML
    private Label error_lbl;

    @FXML
    private Button login_btn;

    @FXML
    private PasswordField password_fld;

    @FXML
    private TextField user_fld;

    @FXML
    private Text register_lbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        error_lbl.setText("");
        Platform.runLater(() -> {
            Scene scene = login_btn.getScene();
            if (scene != null) {
                scene.setOnKeyPressed(event -> {
                    if (event.getCode() == KeyCode.ENTER) {
                        onLogin();
                    }
                });
            }
        });
        acc_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT, AccountType.ADMIN));
        acc_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        acc_selector.valueProperty().addListener(Observable -> Model.getInstance().getViewFactory().setLoginAccountType(acc_selector.getValue()));;
        login_btn.setOnAction(event -> onLogin());
        register_lbl.setOnMouseClicked(event -> onRegister());
    }

    private void onRegister() {
        System.out.println("> register");
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closedStage(stage);
        Model.getInstance().getViewFactory().showRegisterWindow();
    }

    private void onLogin() {
        System.out.println(login_btn.toString());
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CLIENT) {
            /*
             * LOGIN: CLIENT CREDENTIALS
             */
            Model.getInstance().evaluateClientCredentials(user_fld.getText(), password_fld.getText());
            System.out.println(Model.getInstance().getClientLoginSucessFlag());
            if (Model.getInstance().getClientLoginSucessFlag()) {
                Model.getInstance().getViewFactory().closedStage(stage);
                Model.getInstance().getViewFactory().showClientWindow();
            } else {
                error_lbl.setVisible(true);;
                error_lbl.setText("Error de inicio de sesión");
            }

        } else {
            System.out.println("ADMIN ----");
            /*
             * ADMIN: ADMIN CREDENTIALS
             */
            if (Model.getInstance().evaluateAdminCredentials(user_fld.getText(), password_fld.getText())) {
                System.out.println("LOGEO DEL ADMIN");
                Model.getInstance().getViewFactory().closedStage(stage);
                Model.getInstance().getViewFactory().showAdminView();
            } else {
                System.out.println("NO LOGEO");
            }
        }
    }

}
