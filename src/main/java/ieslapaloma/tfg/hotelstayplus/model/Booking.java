package ieslapaloma.tfg.hotelstayplus.model;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "booking",
uniqueConstraints = @UniqueConstraint(name = "unique_booking_hotel_dates", 
columnNames = {"id_hotel", "date_start", "date_end"}))
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "date_end")
    private LocalDate dateEnd;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "booking_code")
    private String bookingCode;

    @Column(name = "number_nights")
    private Integer numbernights;
    
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

    
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Booking [id=" + id + ", client=" + client + ", hotel=" + hotel + ", dateStart=" + dateStart
                + ", dateEnd=" + dateEnd + ", totalPrice=" + totalPrice + "]";
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public Integer getNumbernights() {
        return numbernights;
    }

    public void setNumbernights(Integer numbernights) {
        this.numbernights = numbernights;
    }
    
    
}
