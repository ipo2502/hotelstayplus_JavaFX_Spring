package ieslapaloma.tfg.hotelstayplus.model;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String username;

    @Column
    private int img_n;
    
    @Column
    private String password;

    @Column
    private String phoneNumber;
    
    public Client() {}

    
    
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



    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", img_n="
                + img_n + ", password=" + password + ", phoneNumber=" + phoneNumber + "]";
    }

    
    
}
