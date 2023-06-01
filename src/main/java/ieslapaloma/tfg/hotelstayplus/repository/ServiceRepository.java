package ieslapaloma.tfg.hotelstayplus.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ieslapaloma.tfg.hotelstayplus.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{
    @Query("SELECT s FROM Service s INNER JOIN s.hotels h WHERE h.id = :hotelId")
    List<Service> findServicesByHotelId(@Param("hotelId") Long hotelId);
}
