package ieslapaloma.tfg.hotelstayplus.model;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @Column
    private String name;

    @Column
    private String surnames;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    @Column
    private int img_n;
    
    @Column
    private String password;

    @Column(unique = true)
    private String phoneNumber;

    @Column
    private String address;
    
    public Client() {}

    
    
    public Client(String name, String surnames, String email, String username, int img_n, String password,
            String phoneNumber, String address) {
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        this.username = username;
        this.img_n = img_n;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
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



    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }



    public int getImg_n() {
        return img_n;
    }



    public void setImg_n(int img_n) {
        this.img_n = img_n;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }



    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public String getSurnames() {
        return surnames;
    }



    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }



    public String getAddress() {
        return address;
    }



    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", img_n="
                + img_n + ", password=" + password + ", phoneNumber=" + phoneNumber + "]";
    }

    
    
}
