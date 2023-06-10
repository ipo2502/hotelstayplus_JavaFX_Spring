package ieslapaloma.tfg.hotelstayplus.javafx.Views;

import javax.faces.flow.builder.ReturnBuilder;

import ieslapaloma.tfg.hotelstayplus.javafx.PathEnum;
import ieslapaloma.tfg.hotelstayplus.javafx.Paths;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewFactory {

    private BorderPane welcomeWindow;
    private AccountType loginAccountType;

    //Client
    private final ObjectProperty<ClientMenuOptions> clientSelectedMenuItem;
    private VBox clientDashboardView;
    private VBox clientBookingsView;
    private VBox clientProfileView;
    private VBox maxHotelView;
    private VBox hotelBookingView;
    private VBox loadingView;
    private VBox bookingSuccessfulView;
    private VBox failedBookingView;
    private VBox maxBookingView;
    private VBox adminUserView;
    private VBox adminDashboardView;
    private VBox adminHotelsView;
    private VBox adminBookingsView;

    public ViewFactory() {
        this.loginAccountType = AccountType.CLIENT;
        this.clientSelectedMenuItem = new SimpleObjectProperty<>();
    }

    public BorderPane getWelcomeWindowView() {
        if (welcomeWindow == null) {
            try {
                welcomeWindow = Paths.getFXML(PathEnum.WELCOMEWINDOW, getClass()).load(); //
            } catch (Exception e) {
                System.err.println("Exception WelcomeWindowView(): " +e.getLocalizedMessage());
            }
        }
        return welcomeWindow;
    }

    public void showWelcomeWindow() {
        //C:\Users\ignac\Downloads\hotelstayplus\hotelstayplus\src\main\resources\ieslapaloma\tfg\FXML\welcomeWindow.fxml
        FXMLLoader loader = Paths.getFXML(PathEnum.WELCOMEWINDOW, getClass());
       // FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/ieslapaloma/tfg/FXML/welcomeWindow.fmxl"));
        createStage(loader);
     }

    public void showClientWindow() {
        FXMLLoader loader = Paths.getFXML(PathEnum.CLIENT, getClass());
        createStage(loader);
    }

    public void showRegisterWindow() {
        FXMLLoader loader = Paths.getFXML(PathEnum.REGISTER, getClass());
        createStage(loader);

    }

    public void showAdminView() {
        FXMLLoader loader = Paths.getFXML(PathEnum.ADMIN, getClass());
        createStage(loader);

    }
 
    public void showOtherDashboardView() {
        FXMLLoader loader = Paths.getFXML(PathEnum.OTHERDASHBOARD, getClass());
        createStage(loader);
    }

    public void showMaxHotelView() {
        FXMLLoader loader = Paths.getFXML(PathEnum.FULLHOTEL, getClass());
        createStage(loader);

    }
     
     private void createStage(FXMLLoader loader) {
         Scene scene = null;
         try {
             scene = new Scene(loader.load());
         } catch (Exception e) {
             e.printStackTrace();
         }
         Stage stage = new Stage();
         stage.setScene(scene);
         //stage.getIcons().add(new Image(String.valueOf(Paths.getImg(PathEnum.IMG_ICON, getClass()))));
         stage.setTitle("HotelStay");
         stage.setResizable(false);
 
         stage.show();
     }
     
     public AccountType getLoginAccountType() { return loginAccountType;}
 
     public void closedStage(Stage stage) {
         stage.close();
     }
 
     public void showLoginWindow() {
         FXMLLoader loader = Paths.getFXML(PathEnum.LOGIN, getClass());
         createStage(loader);
     }

     public void setLoginAccountType(AccountType logiAccountType) {this.loginAccountType = logiAccountType;}

     public ObjectProperty<ClientMenuOptions> getClientSelectedMenuItem() {
        return clientSelectedMenuItem;
    }

    public VBox getDashboardView() {
        System.out.println("> selected Dashboard");
        if (clientDashboardView == null) {
            try {
                clientDashboardView = Paths.getFXML(ClientMenuOptions.DASHBOARD, getClass()).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return clientDashboardView;
    }

    public VBox getBookingsView() {
        System.out.println("> selected Bookings");
        if (clientBookingsView == null) {
            try {
                clientBookingsView = Paths.getFXML(ClientMenuOptions.BOOKINGS, getClass()).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return clientBookingsView;
    }

    public VBox getProfileView() {
        System.out.println("> selected Profile");
        if (clientProfileView == null) {
            try {
                clientProfileView = Paths.getFXML(ClientMenuOptions.PROFILE, getClass()).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return clientProfileView;
    }

    public VBox getMaxView() {
        System.out.println("> selected hotel");
        if (maxHotelView == null) {
            try {
                maxHotelView = Paths.getFXML(ClientMenuOptions.MAX, getClass()).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return maxHotelView;
    }

    public VBox getHotelBookingView() {
        System.out.println("> selected booking view");
        if (hotelBookingView == null) {
            try {
                hotelBookingView = Paths.getFXML(ClientMenuOptions.BOOKINGHOTEL, getClass()).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hotelBookingView;
    }

    public VBox getLoadingView() {
        System.out.println("> loading");
        if (loadingView == null) {
            try {
                loadingView = Paths.getFXML(ClientMenuOptions.LOADING, getClass()).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return loadingView;
    }

    public VBox getBookingSuccessfulView() {
        System.out.println("> successful");
        if (bookingSuccessfulView == null) {
            try {
                bookingSuccessfulView = Paths.getFXML(ClientMenuOptions.SUCCESSFULBOOKING, getClass()).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bookingSuccessfulView;
    }

    public VBox getFailedBookingView() {
        System.out.println("> failed");
        if (failedBookingView == null) {
            try {
                failedBookingView = Paths.getFXML(ClientMenuOptions.FAILEDBOOKING, getClass()).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return failedBookingView;
    }

    public VBox getMaxBookingView() {
        System.out.println("> maxBooking");
        if (maxBookingView == null) {
            try {
                maxBookingView = Paths.getFXML(ClientMenuOptions.MAXBOOKING, getClass()).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return maxBookingView;
    }

    public VBox getAdminUserView() {
        System.out.println("> admin user");
        if (adminUserView == null) {
            try {
                adminUserView = Paths.getFXML(ClientMenuOptions.ADMINUSER, getClass()).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return adminUserView;
    }

    public VBox getAdminDashboardView() {
        System.out.println("> adminDashboardView ");
        if (adminDashboardView == null) {
            try {
                adminDashboardView = Paths.getFXML(ClientMenuOptions.ADMINDASHBOARD, getClass()).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return adminDashboardView;
    }

    public VBox getAdminHotelsView() {
        System.out.println("> AdminHotelsView ");
        if (adminHotelsView == null) {
            try {
                adminHotelsView = Paths.getFXML(ClientMenuOptions.ADMINHOTELS, getClass()).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return adminHotelsView;
    }

    public VBox getAdminBookingsView() {
        System.out.println("> AdminBookingsView ");
        if (adminBookingsView == null) {
            try {
                adminBookingsView = Paths.getFXML(ClientMenuOptions.ADMINBOOKINGS, getClass()).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return adminBookingsView;
    }
    
}
