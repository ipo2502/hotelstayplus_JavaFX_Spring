package ieslapaloma.tfg.hotelstayplus.javafx.Models;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
@Entity
@Table(name = "HOTELS")
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

    //servicios como entity para un futuro




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

    private String POJOname;
    private String imageSrc;
    private String pOJOlocatioString;
    private String starsSrc;
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
    
}
