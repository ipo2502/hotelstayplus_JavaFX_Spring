package ieslapaloma.tfg.hotelstayplus.model;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "date_end")
    private LocalDate dateEnd;

    /*@Column(name = "total_price")
    private double totalPrice;
*/
    public Booking(Client client, Hotel hotel, LocalDate dateStart, LocalDate dateEnd) {
        this.client = client;
        this.hotel = hotel;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Booking() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client cliente) {
        this.client = cliente;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate fechaInicio) {
        this.dateStart = fechaInicio;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate fechaFin) {
        this.dateEnd = fechaFin;
    }

    /*
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
 */
    
}
