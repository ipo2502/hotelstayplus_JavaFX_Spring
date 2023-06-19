package ieslapaloma.tfg.hotelstayplus.javafx.Controllers.Admin;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.javafx.Paths;
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

public class AdminAddHotelController implements Initializable{
    public static AdminAddHotelController instance;

    @FXML
    private Button addNHotel_btn;

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
    private Label date1_lbl13;

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
    private CheckBox desayuno_cbox;

    @FXML
    private TextField email_fld;

    @FXML
    private TextField hotelName_fld;

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
    int totalImgN = 25;

    private List<Service> allServices = List.of(
        new Service(1L, "wifi"), 
        new Service(2L, "bar"), 
        new Service(3L, "desayuno"), 
        new Service(4L, "24Horas"), 
        new Service(5L, "parking"));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        addNHotel_btn.setOnAction(event -> onAdd());
        leftArrow_btn.setOnAction(event -> onArrowLeft());
        rightArrow_btn.setOnAction(event -> onArrowRight());
    }

    public static AdminAddHotelController getInstance() {
        return instance;
    }

    public void onAdd() {
        Hotel hotel = new Hotel();

        hotel.setName(hotelName_fld.getText());
        hotel.setEmail(email_fld.getText());
        hotel.setPhoneNumber(phoneNumber_fld.getText());
        hotel.setPostalCode(postalCode_fld.getText());
        hotel.setWebsite(web_fld.getText());
        hotel.setCity(city_fld.getText());
        hotel.setLocation(address_fld.getText());
        hotel.setStars(Integer.valueOf(stars_fld.getText()));
        hotel.setRating(Double.valueOf(rating_fld.getText()));
        hotel.setPrice(Double.valueOf(price_fld.getText()));
        hotel.setHotelImg_n(Integer.valueOf(img_fld.getText()));
        Random r = new Random();
        hotel.setDescription_n1(r.nextInt(5));
        hotel.setDescription_n2(r.nextInt(5));
        hotel.setServices(loadServicesChosen());
        DBManager.getInstance().getHotelService().addHotel(hotel);
        AdminHotelController.getInstance().load();
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

    private void onArrowLeft() {
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
        int img_n = Integer.valueOf(img_fld.getText());
        img_n = getNextImg_N(img_n);
        img_fld.setText(String.valueOf(img_n));
        loadImage(img_n);

    }

}
