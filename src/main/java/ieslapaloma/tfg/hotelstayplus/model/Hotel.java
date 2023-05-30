package ieslapaloma.tfg.hotelstayplus.model;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
@Entity
@Table(name = "hotels")
public class Hotel {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
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

    @Column(name = "img_n")
    private int img_n;

    public Hotel() {}

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

    public int getImg_n() {
        return img_n;
    }

    public void setImg_n(int img_n) {
        this.img_n = img_n;
    }



    @Transient
    private String POJOname; //retirar en un futuro
    @Transient
    private String imageSrc;
    @Transient
    private String pOJOlocatioString;//retirar en un futuro
    @Transient
    private String starsSrc;
    @Transient
    private String backgroundImg;

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

    
    
}
