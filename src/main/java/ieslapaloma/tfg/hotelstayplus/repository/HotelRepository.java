package ieslapaloma.tfg.hotelstayplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import ieslapaloma.tfg.hotelstayplus.model.Service;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{
    List<Service> findServicesById(Long hotelId);

}
