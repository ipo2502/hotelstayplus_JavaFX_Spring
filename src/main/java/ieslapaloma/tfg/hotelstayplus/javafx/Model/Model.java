package ieslapaloma.tfg.hotelstayplus.javafx.Model;

import java.sql.ResultSet;

import ieslapaloma.tfg.hotelstayplus.DBManager;
import ieslapaloma.tfg.hotelstayplus.javafx.Database.DatabaseDriver;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.AccountType;
import ieslapaloma.tfg.hotelstayplus.javafx.Views.ViewFactory;
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

    private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        
        this.clientLoginSucessFlag = false;


    }

    public static Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }
    
    public ViewFactory getViewFactory() {return viewFactory;}
    
    public void setLoginAccountType(AccountType logiAccountType) {this.loginAccountType = logiAccountType;}
    public AccountType getLoginAccountType() {return loginAccountType;}
    public boolean getClientLoginSucessFlag() {return this.clientLoginSucessFlag;}

    public void setClientLoginSucesssFlag(boolean flag) {this.clientLoginSucessFlag = flag;}
    public void setSelectedModelHotel(Hotel hotel) {this.modelHotel = hotel;}
    public Client getModelClient() { return this.modelClient;}
    public Hotel getModelHotel() { return this.modelHotel;}
    /*
    * Client Section
    */
    //CAMBIAR CON EL DBMANAGER
    public void evaluateClientCredentialsB(String user, String password) {
        ResultSet resultSet = databaseDriver.getClientData(user, password);
        try {
            if (resultSet.next()) {
                //Pojo add data to a User/Client object
                modelClient = new Client();
                modelClient.setName(user);
                modelClient.setEmail(password);
                this.clientLoginSucessFlag = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void evaluateClientCredentials(String user, String password) {
        Client client = DBManager.getInstance().getClientService().loginClient(user, password);
        if (client != null) {
            modelClient = client;
            this.clientLoginSucessFlag = true;
        } else {
            System.out.println("no se encontró el usuario");
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
