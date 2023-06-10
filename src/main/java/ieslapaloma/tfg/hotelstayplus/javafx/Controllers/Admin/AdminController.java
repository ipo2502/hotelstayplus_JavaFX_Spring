package ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Admin;

import java.net.URL;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class AdminController implements Initializable {

    public BorderPane client_parentAdmin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem()
        .addListener((observable, oldValue, newValue) -> {
            switch(newValue) {
                case ADMINUSER -> client_parentAdmin.setCenter(Model.getInstance().getViewFactory().getAdminUserView());
                case ADMINDASHBOARD -> client_parentAdmin.setCenter(Model.getInstance().getViewFactory().getAdminDashboardView());
                case ADMINBOOKINGS -> client_parentAdmin.setCenter(Model.getInstance().getViewFactory().getAdminBookingsView());
                case ADMINHOTELS -> client_parentAdmin.setCenter(Model.getInstance().getViewFactory().getAdminHotelsView());
                default -> client_parentAdmin.setCenter(Model.getInstance().getViewFactory().getDashboardView());
                
            }
        });
    }
    
}
