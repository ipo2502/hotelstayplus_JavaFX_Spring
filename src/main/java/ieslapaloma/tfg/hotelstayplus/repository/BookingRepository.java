package ieslapaloma.tfg.hotelstayplus.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ieslapaloma.tfg.hotelstayplus.model.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
    
}
