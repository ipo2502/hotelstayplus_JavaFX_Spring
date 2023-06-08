package ieslapaloma.tfg.hotelstayplus.javafx.Model;

import java.sql.ResultSet;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.javafx.Database.DatabaseDriver;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.AccountType;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.ViewFactory;
import ieslapaloma.tfg.hotelstayplus.model.Booking;
import ieslapaloma.tfg.hotelstayplus.model.Client;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;


public class Model {

    private static Model model;
    private ViewFactory viewFactory;
    private AccountType loginAccountType = AccountType.CLIENT;
    private DatabaseDriver databaseDriver;
    private boolean login = false;
    private boolean clientLoginSucessFlag;
    private Client modelClient;
    private Hotel modelHotel;
    private Booking modelBooking;
    private boolean successfulBookingFlag;

    private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        
        this.clientLoginSucessFlag = false;
        this.successfulBookingFlag = true;

    }

    public static Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }
    
    public ViewFactory getViewFactory() {return viewFactory;}
    public void setClientLoginSucessFlag(boolean login) {this.clientLoginSucessFlag = login;}
    public void setLoginAccountType(AccountType logiAccountType) {this.loginAccountType = logiAccountType;}
    public AccountType getLoginAccountType() {return loginAccountType;}
    public boolean getClientLoginSucessFlag() {return this.clientLoginSucessFlag;}
    public boolean getSuccessfulBookingFlag() { return this.successfulBookingFlag;}//cambiar a isBookingFlag
    public void setSuccessfulBookingFlag(boolean flag) { this.successfulBookingFlag = flag;} 
    public void setClientLoginSucesssFlag(boolean flag) {this.clientLoginSucessFlag = flag;}
    public void setSelectedModelHotel(Hotel hotel) {this.modelHotel = hotel;}
    public void setModelBooking(Booking booking) { this.modelBooking = booking;}
    public Client getModelClient() { return this.modelClient;}
    public void setModelClient(Client client) {this.modelClient = client; }
    public Hotel getModelHotel() { return this.modelHotel;}
    public Booking getModelBooking() { return this.modelBooking; }

    /*
    * Client Section
    */


    public void evaluateClientCredentials(String user, String password) {
        Client client = DBManager.getInstance().getClientService().loginClient(user, password);
        if (client != null) {
            modelClient = client;
            this.clientLoginSucessFlag = true;
        } else {
            System.out.println("no se encontró el usuario");
        }
    }

    /*
     * ADMIN SECTION
     */

     public boolean evaluateAdminCredentials(String user, String password) {
        if (user.equals("igna") && password.equals("2")) {
            return true;
        } else {
            return false;
        }
     }

    public void start() {
        if (login) {
            Model.getInstance().getViewFactory().showWelcomeWindow();

        } else {
            Model.getInstance().getViewFactory().showLoginWindow();
        }
        System.out.println("::::::::::::::: -z> "+System.getProperty("java.version")); System.out.println(System.getProperty("javafx.version")); 
    }

    
    
}
