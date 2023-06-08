package ieslapaloma.tfg.hotelstayplus.repository;
import java.time.LocalDate;
import java.util.List;

//import org.springframework.data.jdbc.repository.query.;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ieslapaloma.tfg.hotelstayplus.model.Booking;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
    List<Booking> findBookingsByClientId(Long id_client);

    @Query("SELECT b FROM Booking b WHERE b.hotel = :hotel AND b.dateStart <= :dateEnd AND b.dateEnd >= :dateStart")
    List<Booking> findByHotelAndDateRange(Hotel hotel, LocalDate dateStart, LocalDate dateEnd);

}
