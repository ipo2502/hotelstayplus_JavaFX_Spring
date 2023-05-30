package ieslapaloma.tfg.hotelstayplus.javafx;

import java.io.IOException;

import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Model.getInstance().start();
    }

    public static void main(String[] args) {
        launch();
    }

}