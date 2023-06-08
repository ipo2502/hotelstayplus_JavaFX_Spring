package ieslapaloma.tfg.hotelstayplus.javafx;

import java.net.URL;

import ieslapaloma.tfg.hotelstayplus.javafx.Views.ClientMenuOptions;
import javafx.fxml.FXMLLoader;

public class Paths { //C:\Users\ignac\Downloads\hotelstayplus\hotelstayplus\src\main\resources\FXML\login.fxml

    final static String fxmlPath = "/ieslapaloma/tfg/FXML/";
    final static String imagesPath = "/ieslapaloma/tfg/Images/"; 

     static String[] description1 = {
        " es un lujoso refugio situado en la hermosa costa de una isla paradisíaca. Con su arquitectura moderna y elegante, este hotel de cinco estrellas ofrece a sus huéspedes una experiencia inigualable de comodidad y lujo.",
        "Ubicado en el corazón de la animada ciudad, este hotel combina la elegancia clásica con comodidades modernas. Disfruta de habitaciones espaciosas, un servicio excepcional y vistas impresionantes de la ciudad. Nuestro hotel es perfecto tanto para viajeros de negocios como para turistas que desean explorar todo lo que la ciudad tiene para ofrecer.",
        "Situado en un pintoresco pueblo cerca de la costa, nuestro hotel ofrece una escapada tranquila y relajante. Disfruta de la belleza natural de los alrededores, relájate en nuestras cómodas habitaciones y saborea deliciosos platos locales en nuestro restaurante. Nuestro amable personal estará encantado de ayudarte a aprovechar al máximo tu estancia.",
        " se encuentra en el corazón del bullicioso centro de la ciudad. Disfruta de la comodidad de estar cerca de las principales atracciones turísticas, tiendas y restaurantes. Nuestras elegantes habitaciones ofrecen todas las comodidades que necesitas para una estancia agradable, y nuestro personal atento está disponible las 24 horas para asegurarse de que tengas una experiencia inolvidable en la ciudad.",
        "Ubicado en el centro vibrante de la ciudad, nuestro hotel urbano te brinda un refugio tranquilo en medio del bullicio. Con un diseño sofisticado y moderno, nuestras habitaciones ofrecen comodidad y estilo en cada detalle. Disfruta de servicios de lujo, como un relajante spa, un gimnasio de última generación y una variedad de opciones gastronómicas que deleitarán tus sentidos. Descubre un retiro urbano perfecto para explorar todos los encantos de la ciudad y relajarte después de un día ocupado.",
        "Sumérgete en un mundo de lujo frente al mar en nuestro hotel de playa de primer nivel. Disfruta de impresionantes vistas al océano, acceso directo a la playa y servicios exclusivos para una experiencia inolvidable. Relájate en nuestras elegantes habitaciones, degusta exquisiteces culinarias en nuestros restaurantes con vista al mar y relájate en nuestras piscinas de lujo. Descubre el encanto y la belleza de la vida junto al mar en nuestro hotel."
    };
    static String[] description2 = {
        "Ubicado en un entorno idílico, rodeado de exuberantes jardines tropicales y con vistas impresionantes al océano, este hotel combina a la perfección la belleza natural con las comodidades modernas.", 
        "Nuestra mejor habitación estándar te ofrece una estancia cómoda y relajante. Con una decoración moderna y acogedora, esta habitación cuenta con una cama king-size, un escritorio espacioso y un baño privado con todas las comodidades. Disfruta de vistas panorámicas de la ciudad y servicios adicionales como TV de pantalla plana y acceso a internet de alta velocidad.",
        "Descansa en nuestra habitación estándar más exclusiva, rodeada de la belleza natural de las montañas. Con una cama queen-size y una decoración rústica, esta habitación te brinda la tranquilidad que necesitas después de un día de aventuras al aire libre. Disfruta de las vistas panorámicas desde tu balcón privado y relájate en la comodidad de tu propio refugio en la montaña.",
        "Nuestra mejor habitación estándar frente al mar es perfecta para los amantes de la playa. Despierta cada mañana con impresionantes vistas del océano desde tu balcón privado. La habitación cuenta con una cama doble o dos camas individuales, un baño privado y todas las comodidades necesarias para una estancia relajante y confortable. Disfruta del sonido de las olas y la brisa marina en esta escapada playera.",
        " Con una ubicación privilegiada, esta habitación ofrece comodidad y estilo en un entorno auténtico. Disfruta de una cama cómoda, un ambiente tranquilo y todas las comodidades modernas que necesitas. Explora las calles empedradas y los sitios históricos cercanos antes de relajarte en tu acogedora habitación.",
        "Nuestra mejor habitación estándar en el corazón de la ciudad combina estilo y comodidad. Con una decoración elegante y moderna, esta habitación cuenta con una cama queen-size, un área de trabajo funcional y un baño privado con ducha de alta presión. Disfruta de todas las comodidades necesarias para una estancia agradable en la ciudad, como TV de pantalla plana, minibar y servicio de habitaciones las 24 horas."
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
            case ADMIN:
                return new FXMLLoader(cl.getResource(fxmlPath + "Admin/admin.fxml"));
            case REGISTER:
                return new FXMLLoader(cl.getResource(fxmlPath + "register.fxml"));
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
            case BOOKINGHOTEL:
                return new FXMLLoader(cl.getResource(fxmlPath + "Client/bookingPage.fxml"));
            case LOADING:
                return new FXMLLoader(cl.getResource(fxmlPath + "Client/loading.fxml"));
            case SUCCESSFULBOOKING:
                return new FXMLLoader(cl.getResource(fxmlPath + "Client/successfulBooking.fxml"));
            case FAILEDBOOKING:
                return new FXMLLoader(cl.getResource(fxmlPath + "Client/failedBooking.fxml"));
            case MAXBOOKING:
                return new FXMLLoader(cl.getResource(fxmlPath + "Client/maxBooking.fxml"));
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
            case 2: return description1[1];
            case 3: return description1[2];
            case 4: return "El Hotel " +name+description1[3];
            case 5: return description1[4];
            case 6: return description1[5];
            default: return "";
        }
    }

    public static String getDescription2(int img_n) {
        switch(img_n) {
            case 1: return description2[0];
            case 2: return description2[1];
            case 3: return description2[2];
            case 4: return description2[3];
            case 5: return description2[4];
            case 6: return description2[5];
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

