package ieslapaloma.tfg.hotelstayplus.javafx;

import java.net.URL;

import ieslapaloma.tfg.hotelstayplus.javafx.Views.ClientMenuOptions;
import javafx.fxml.FXMLLoader;

public class Paths { //C:\Users\ignac\Downloads\hotelstayplus\hotelstayplus\src\main\resources\FXML\login.fxml

    final static String fxmlPath = "/ieslapaloma/tfg/FXML/";
    final static String imagesPath = "/ieslapaloma/tfg/Images/"; 

     static String[] description1 = {
        " es un lujoso refugio situado en la hermosa costa de una isla paradisíaca. Con su arquitectura moderna y elegante, este hotel de cinco estrellas ofrece a sus huéspedes una experiencia inigualable de comodidad y lujo."
    };
    static String[] description2 = {
        "Ubicado en un entorno idílico, rodeado de exuberantes jardines tropicales y con vistas impresionantes al océano, este hotel combina a la perfección la belleza natural con las comodidades modernas."
    };
    


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
            case FULLHOTEL:
                return new FXMLLoader(cl.getResource(fxmlPath + "Client/fullHotel.fxmls"));
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
            case MAX:
                return new FXMLLoader(cl.getResource(fxmlPath + "Client/fullHotelWithout.fxml"));
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

    public static String getHotelUrlImage(int img_n) {
        switch(img_n) {
            case 1: return "/ieslapaloma/tfg/Images/hotel_sample.jpg";
            case 2: return "/ieslapaloma/tfg/Images/hotel_sample2.jpg";
            case 3: return "/ieslapaloma/tfg/Images/hotel_sample3.jpg";
            case 4: return "/ieslapaloma/tfg/Images/hotel_sample4.jpg";
            case 5: return "/ieslapaloma/tfg/Images/hotel_sample5.jpg";
            case 6: return "/ieslapaloma/tfg/Images/hotel_sample6.jpg";
            case 7: return "/ieslapaloma/tfg/Images/stars1.png";
            case 8: return "/ieslapaloma/tfg/Images/stars2.png";
            case 9: return "/ieslapaloma/tfg/Images/stars3.png";
            case 10: return "/ieslapaloma/tfg/Images/stars4.png";
            case 11: return "/ieslapaloma/tfg/Images/stars5.png";

            default: return "";
        }
    }

    public static String getBedroomUrlImage(int img_n) {
        switch(img_n) {
            case 1: return "/ieslapaloma/tfg/Images/bedroom_sample.jpg";
            case 2: return "/ieslapaloma/tfg/Images/bedroom_sample2.jpg";
            case 3: return "/ieslapaloma/tfg/Images/bedroom_sample3.jpg";
            case 4: return "/ieslapaloma/tfg/Images/bedroom_sample4.jpg";
            case 5: return "/ieslapaloma/tfg/Images/bedroom_sample5.jpg";
            case 6: return "/ieslapaloma/tfg/Images/bedroom_sample6.jpg";
            default: return "";
        }
    }

    public static String getDescription1(int img_n, String name) {
        switch(img_n) {
            case 1: return "El Hotel "+name+description1[0];
            case 2: return "/ieslapaloma/tfg/Images/bedroom_sample2.jpg";
            case 3: return "/ieslapaloma/tfg/Images/bedroom_sample3.jpg";
            case 4: return "/ieslapaloma/tfg/Images/bedroom_sample4.jpg";
            case 5: return "/ieslapaloma/tfg/Images/bedroom_sample5.jpg";
            case 6: return "/ieslapaloma/tfg/Images/bedroom_sample6.jpg";
            default: return "";
        }
    }

    public static String getDescription2(int img_n) {
        switch(img_n) {
            case 1: return description2[0];
            case 2: return "/ieslapaloma/tfg/Images/bedroom_sample2.jpg";
            case 3: return "/ieslapaloma/tfg/Images/bedroom_sample3.jpg";
            case 4: return "/ieslapaloma/tfg/Images/bedroom_sample4.jpg";
            case 5: return "/ieslapaloma/tfg/Images/bedroom_sample5.jpg";
            case 6: return "/ieslapaloma/tfg/Images/bedroom_sample6.jpg";
            default: return "";
        }
    }


    /*
     *         "/ieslpaloma/Images/stars1.png",
        "/estoyharto/Images/stars2.png",
        "/estoyharto/Images/stars3.png",
        "/estoyharto/Images/stars4.png",
        "/estoyharto/Images/stars5.png"
     */
    
}

