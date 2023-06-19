package ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Admin;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.annotations.OnDelete;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.javafx.Paths;
import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.model.Booking;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import ieslapaloma.tfg.hotelstayplus.model.Service;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AdminSingleHotelController implements Initializable{

    @FXML
    private TextField address_fld;

    @FXML
    private ImageView backgroundImg_img;

    @FXML
    private CheckBox bar_cbox;

    @FXML
    private TextField city_fld;

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
    private Label date1_lbl121;

    @FXML
    private Label date1_lbl1211;

    @FXML
    private Label date1_lbl122;

    @FXML
    private Label date1_lbl2;

    @FXML
    private Label date1_lbl21;

    @FXML
    private Label date1_lbl211;

    @FXML
    private Label date1_lbl212;

    @FXML
    private Label date1_lbl2121;

    @FXML
    private Label date1_lbl21211;

    @FXML
    private Label date1_lbl2122;

    @FXML
    private Button delete_btn;

    @FXML
    private CheckBox desayuno_cbox;

    @FXML
    private Button edit_btn;

    @FXML
    private TextField email_fld;

    @FXML
    private Label hotelName_lbl;

    @FXML
    private Label hotelName_lbl1;

    @FXML
    private Label hotelName_lbl11;

    @FXML
    private CheckBox hours24_cbox;

    @FXML
    private Label id_lbl;

    @FXML
    private ImageView imgChoose_img;

    @FXML
    private TextField img_fld;

    @FXML
    private Button leftArrow_btn;

    @FXML
    private ImageView little_img;

    @FXML
    private CheckBox parking_cbox;

    @FXML
    private TextField phoneNumber_fld;

    @FXML
    private TextField postalCode_fld;

    @FXML
    private TextField price_fld;

    @FXML
    private TextField rating_fld;

    @FXML
    private Button rightArrow_btn;

    @FXML
    private TextField stars_fld;

    @FXML
    private TextField web_fld;

    @FXML
    private CheckBox wifi_cbox;

    boolean edit1 = false;
    int totalImgN = 25;

    private List<Service> allServices = List.of(
        new Service(1L, "wifi"), 
        new Service(2L, "bar"), 
        new Service(3L, "desayuno"), 
        new Service(4L, "24Horas"), 
        new Service(5L, "parking"));



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        leftArrow_btn.setOnAction(event -> onArrowLeft());
        rightArrow_btn.setOnAction(event -> onArrowRight());
        edit_btn.setOnAction(event -> onEdit());
        delete_btn.setOnAction(event -> onDelete());
    }

    private void pulse() {
        if (edit1) {
            edit1 = false;
        } else {
            edit1 = true;
        }
    }

    private void loadGraphicServices(List<Service> services) {
        if (services != null) {

        
        for (Service s : services) {
            switch(Math.toIntExact(s.getId())) {
                case 1:
                    wifi_cbox.setSelected(true);
                    break;
                case 2:
                    bar_cbox.setSelected(true);
                    break;
                case 3:
                    desayuno_cbox.setSelected(true);
                    break;
                case 4:
                    hours24_cbox.setSelected(true);
                    break;
                case 5:
                    parking_cbox.setSelected(true);
                    break;
                default:
                    break;
            }
        }
    }
    }

    private void onEdit() {
        pulse();
        if (edit1) {
            setAllDisable(false);
            leftArrow_btn.setVisible(true);
            rightArrow_btn.setVisible(true);
            edit_btn.setStyle("-fx-background-color: rgba(145, 255, 135, 0.788);");
            

        } else {
            edit_btn.setStyle("-fx-background-color: rgba(135, 143, 255, 0.788);");
            Hotel hotel = DBManager.getInstance().getHotelService().getHotelById(Long.valueOf(id_lbl.getText())).get();
            hotel.setWebsite(web_fld.getText());
            hotel.setEmail(email_fld.getText());
            hotel.setPhoneNumber(phoneNumber_fld.getText());
            hotel.setPostalCode(postalCode_fld.getText());
            hotel.setCity(city_fld.getText());
            hotel.setLocation(address_fld.getText());
            hotel.setStars(Integer.valueOf(stars_fld.getText()));
            hotel.setRating(Double.valueOf(rating_fld.getText()));
            hotel.setPrice(Double.valueOf(price_fld.getText()));
            hotel.setHotelImg_n(Integer.valueOf(img_fld.getText()));

            List <Service> hotelservices = new ArrayList<>();

            hotel.setServices(loadServicesChosen());
            System.out.println("se va a updatear el cliente " + id_lbl.getText());
            DBManager.getInstance().getHotelService().updateHotel(hotel);
            setAllDisable(true);
            String urlImg = Paths.getHotelUrlImage(hotel.getHotelImg_n());

            Image imageCover = new Image(getClass().getResourceAsStream(urlImg));
            little_img.setImage(imageCover);
            leftArrow_btn.setVisible(false);
            rightArrow_btn.setVisible(false);
        }

    }

    private List<Service> loadServicesChosen() {
        List <Service> services = new ArrayList<>();
        if (wifi_cbox.isSelected()) services.add(allServices.get(0));
        if (bar_cbox.isSelected()) services.add(allServices.get(1));
        if (desayuno_cbox.isSelected()) services.add(allServices.get(2));
        if (hours24_cbox.isSelected()) services.add(allServices.get(3));
        if (parking_cbox.isSelected()) services.add(allServices.get(4));

        return services;
    }

    private void onDelete() {
        Long id = Long.valueOf(id_lbl.getText());
        System.out.println("delete hotel with id" +id);
        DBManager.getInstance().getHotelService().deleteHotelById(id);
        AdminHotelController.getInstance().load();
    }

    private void onArrowLeft() {
        System.out.println("left");
        int img_n = Integer.valueOf(img_fld.getText());
        img_n = getPreviousImg_N(img_n);
        img_fld.setText(String.valueOf(img_n));
        loadImage(img_n);
    }

    private void loadImage(int n) {
        String urlImg = Paths.getHotelUrlImage(n);

        Image imageCover = new Image(getClass().getResourceAsStream(urlImg));
        imgChoose_img.setImage(imageCover);
    }

    private int getPreviousImg_N(int n) {
        if (n > 1 && n <= totalImgN) {
            return n-1;
        } else {
            return totalImgN;
        }
    }
    private int getNextImg_N(int n) {
        if (n < totalImgN) {
            return n+1;
        } else {
            return 1;
        }
    }

    private void onArrowRight() {
        System.out.println("right");

        int img_n = Integer.valueOf(img_fld.getText());
        img_n = getNextImg_N(img_n);
        img_fld.setText(String.valueOf(img_n));
        loadImage(img_n);

    }

    public void setData(Hotel hotel)  {
        setAllDisable(true);
        leftArrow_btn.setVisible(false);
        rightArrow_btn.setVisible(false);
        hotelName_lbl.setText(hotel.getName());
        web_fld.setText(hotel.getWebsite());
        email_fld.setText(hotel.getEmail());
        postalCode_fld.setText(hotel.getPostalCode());
        phoneNumber_fld.setText(hotel.getPhoneNumber());
        city_fld.setText(hotel.getCity());
        address_fld.setText(hotel.getLocation());
        stars_fld.setText(String.valueOf(hotel.getStars()));
        rating_fld.setText(String.valueOf(hotel.getRating()));
        price_fld.setText(String.valueOf(hotel.getPrice()));
        img_fld.setText(String.valueOf(hotel.getHotelImg_n()));
        id_lbl.setText(String.valueOf(hotel.getId()));


        String urlImg = Paths.getHotelUrlImage(hotel.getHotelImg_n());

        Image imageCover = new Image(getClass().getResourceAsStream(urlImg));
        little_img.setImage(imageCover);
        imgChoose_img.setImage(imageCover);
        List<Service> services = hotel.getServicesPojo();
        Hotel hotel2 = DBManager.getInstance().getHotelService().getHotelById(Long.valueOf(id_lbl.getText())).get();
        List<Service> hotelservices = DBManager.getInstance().getHotelService().getHotelServicesById(hotel2.getId());

        loadGraphicServices(hotelservices);

    }

    private void setAllDisable(boolean b) {
        web_fld.setDisable(b);
        email_fld.setDisable(b);
        phoneNumber_fld.setDisable(b);
        postalCode_fld.setDisable(b);
        city_fld.setDisable(b);
        address_fld.setDisable(b);
        stars_fld.setDisable(b);
        rating_fld.setDisable(b);
        price_fld.setDisable(b);
        img_fld.setDisable(b);
        wifi_cbox.setDisable(b);
        bar_cbox.setDisable(b);
        desayuno_cbox.setDisable(b);
        hours24_cbox.setDisable(b);
        parking_cbox.setDisable(b);
    }
    
}
