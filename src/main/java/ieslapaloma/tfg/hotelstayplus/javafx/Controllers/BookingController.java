package ieslapaloma.tfg.hotelstayplus.javafx.Controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import ieslapaloma.tfg.hotelstayplus.javafx.Paths;
import ieslapaloma.tfg.hotelstayplus.model.Booking;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BookingController implements Initializable{

    public static BookingController instance;
    @FXML
    private Label date1_lbl;

    @FXML
    private Label date2_lbl;

    @FXML
    private Label hotelName_lbl;

    @FXML
    private Label location_lbl;

    @FXML
    private Label price_lbl;

    
    @FXML
    private ImageView backgroundImg_img;

    @FXML
    private AnchorPane container;

    @FXML
    private ImageView little_img;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
    }
    
    public static BookingController getInstance() {
        return instance;
    }
    public void setData(Booking booking) {
        hotelName_lbl.setText(booking.getHotel().getName());
        //price_lbl.setText(booking.getHotel().getPrice());
        location_lbl.setText(booking.getHotel().getLocation());
        String dateStart = formatLocalDate(booking.getDateStart());
        String dateEnd = formatLocalDate(booking.getDateEnd());
        date1_lbl.setText(dateStart);
        date2_lbl.setText(dateEnd);
        int img_n = booking.getHotel().getHotelImg_n();
        Image originalImage = new Image(Paths.getHotelUrlImage(img_n));
        little_img.setImage(originalImage);
        // Define the crop dimensions
        double cropX = 100;  // X-coordinate of the top-left corner of the crop
        double cropY = 200;  // Y-coordinate of the top-left corner of the crop
        double cropWidth = 850;  // Width of the crop
        double cropHeight = 100;  // Height of the crop

        // Create a cropped image
        ImageView croppedImageView = new ImageView(originalImage);
        croppedImageView.setViewport(new javafx.geometry.Rectangle2D(cropX, cropY, cropWidth, cropHeight));
        croppedImageView.setOpacity(0.4);
        container.getChildren().add(0, croppedImageView);

    }

    private String formatLocalDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yy");
        return date.format(formatter);
    }
    
}
