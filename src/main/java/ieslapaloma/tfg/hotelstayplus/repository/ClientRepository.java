package ieslapaloma.tfg.hotelstayplus.repository;
import java.util.Set;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ieslapaloma.tfg.hotelstayplus.model.Client;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import jakarta.transaction.Transactional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
    @Query("SELECT c FROM Client c WHERE c.username = :username AND c.password = :password")
    Client findLoginClient(String username, String password);
    Set<Hotel> findLikedHotelsById(Long clientId);
    
}
