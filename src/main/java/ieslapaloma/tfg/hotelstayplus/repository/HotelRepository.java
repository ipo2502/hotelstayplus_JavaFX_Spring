package ieslapaloma.tfg.hotelstayplus.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ieslapaloma.tfg.hotelstayplus.javafx.Models.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{
    
}
