package ieslapaloma.tfg.hotelstayplus.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ieslapaloma.tfg.hotelstayplus.model.Hotel;
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{
    
}
