package ieslapaloma.tfg.hotelstayplus.javafx;

import java.net.URL;

import ieslapaloma.tfg.hotelstayplus.javafx.Views.ClientMenuOptions;
import javafx.fxml.FXMLLoader;

public class Paths { //C:\Users\ignac\Downloads\hotelstayplus\hotelstayplus\src\main\resources\FXML\login.fxml

    final static String fxmlPath = "/ieslapaloma/tfg/FXML/";
    final static String imagesPath = "/ieslapaloma/tfg/Images/"; 


    public synchronized static FXMLLoader getFXML(PathEnum pathEnum, Class<?> cl) {
        switch(pathEnum) {
            case WELCOMEWINDOW: 
                return new FXMLLoader(cl.getResource("/ieslapaloma/tfg/FXML/welcomeWindow.fxml"));
            case LOGIN:
                return new FXMLLoader(cl.getResource(fxmlPath+ "login.fxml"));
            case CLIENT:
                return new FXMLLoader(cl.getResource(fxmlPath+ "Client/client.fxml"));
            case OTHERDASHBOARD:
                return new FXMLLoader(cl.getResource(fxmlPath+ "Client/clientDashboard2.fxml"));
            default:
                break;

        }
        return null;
    }


    public synchronized static FXMLLoader getFXML(ClientMenuOptions pathEnum, Class<?> cl) {
        switch(pathEnum) {
            case DASHBOARD: 
                return new FXMLLoader(cl.getResource(fxmlPath+ "Client/clientDashboard.fxml"));
            case BOOKINGS:
                return new FXMLLoader(cl.getResource(fxmlPath+ "Client/clientBookings.fxml"));
            case PROFILE:
                return new FXMLLoader(cl.getResource(fxmlPath + "Client/clientProfile.fxml"));
            default:
                break;

        }
        return null;
    }

    public static URL getImg(PathEnum pathEnum, Class<?> cl) {
        switch(pathEnum) {
            case IMG_ICON:
                    return cl.getResource(imagesPath + "icon.png");
            default:
                break;
        }
        return null;
    }
    
}

