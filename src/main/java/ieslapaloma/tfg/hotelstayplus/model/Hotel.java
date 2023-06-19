package ieslapaloma.tfg.hotelstayplus.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
@Entity
@Table(name = "hotels")
public class Hotel {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long id;

    @Column
    private String name;

    @Column
    private Integer stars;

    @Column
    private Double rating;

    @Column
    private String location;

    @Column
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "website")
    private String website;

    @Column(name = "hotelImg_n")
    private Integer hotelImg_n;

    @Column(name = "price")
    private Double price;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    private Integer description_n1;

    private Integer description_n2;

    @ManyToMany
    @JoinTable(
            name = "hotel_service",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Service> services = new ArrayList<>();

    public Hotel() {}

    

    public Hotel(String name, Integer stars, Double rating, String location, String city, String postalCode,
            String website, Integer hotelImg_n, Double price, String phoneNumber, String email) {
        this.name = name;
        this.stars = stars;
        this.rating = rating;
        this.location = location;
        this.city = city;
        this.postalCode = postalCode;
        this.website = website;
        this.hotelImg_n = hotelImg_n;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }



    public Hotel(Long id, String nombre) {
        this.id = id;
        this.name = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    /*
     * Cuando un administrador añada un hotel, se va a poder elegir entre varias fotos con un gridpane en una nueva ventana
     * Cada una de estas fotos va a tener un int identificativo con la ruta de la imagen en local
     * Sería posible crear una tabla en la base de datos de imágenes que tuviera su id y el path, pero vamos a ir viendo cóm lo hacemos
     * De momento vamos a partir con las cinco hotel_sample imágenes que tenemos. 
     */

    public int getHotelImg_n() {
        return hotelImg_n;
    }

    public void setHotelImg_n(int hotelImg_n) {
        this.hotelImg_n = hotelImg_n;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    


    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }



    public Integer getStars() {
        return stars;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setHotelImg_n(Integer hotelImg_n) {
        this.hotelImg_n = hotelImg_n;
    }

    public void setPOJOname(String pOJOname) {
        POJOname = pOJOname;
    }

    public void setpOJOlocatioString(String pOJOlocatioString) {
        this.pOJOlocatioString = pOJOlocatioString;
    }

    

    public Integer getDescription_n1() {
        return description_n1;
    }

    public void setDescription_n1(Integer description_n1) {
        this.description_n1 = description_n1;
    }

    public Integer getDescription_n2() {
        return description_n2;
    }

    public void setDescription_n2(Integer description_n2) {
        this.description_n2 = description_n2;
    }



    @Transient
    private String POJOname; 
    @Transient
    private String imageSrc;
    @Transient
    private String pOJOlocatioString;//retirar en un futuro
    @Transient
    private String starsSrc;
    @Transient
    private String backgroundImg;
    @Transient
    private List<Service> realPojoServices;

    public String getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(String backgroundImg) {
        this.backgroundImg = backgroundImg;
    }
    
    public Hotel(String POJOname, String imageSrc, String location) {
        this.POJOname = name;
        this.imageSrc = imageSrc;
        this.location = location;
    }
    public String getPOJOname() {
        return POJOname;
    }
    public String getImageSrc() {
        return imageSrc;
    }
    public String getpOJOlocatioString() {
        return pOJOlocatioString;
    }
    public void POJOname(String name) {
        this.POJOname = name;
    }
    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }
    public void setpOJOlocation(String pOJOlocatioString) {
        this.pOJOlocatioString = pOJOlocatioString;
    }

    public String getStarsSrc() {
        return starsSrc;
    }

    public void setStarsSrc(String starsSrc) {
        this.starsSrc = starsSrc;
    }

    @Override
    public String toString() {
        return "Hotel [id=" + id + ", name=" + name + ", stars=" + stars + ", rating=" + rating + ", location="
                + location + ", city=" + city + ", postalCode=" + postalCode + ", website=" + website + ", POJOname="
                + POJOname + ", imageSrc=" + imageSrc + ", pOJOlocatioString=" + pOJOlocatioString + ", starsSrc="
                + starsSrc + ", backgroundImg=" + backgroundImg + "]";
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Service> getServicesPojo() {
        return realPojoServices;
    }

    public void setRealPojoServices(List<Service> realPojoServices) {
        this.realPojoServices = realPojoServices;
    }

    public List<Service> getRealPojoServices() {
        return realPojoServices;
    }

    
    
}
