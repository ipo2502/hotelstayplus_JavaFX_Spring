package ieslapaloma.tfg.hotelstayplus.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ieslapaloma.tfg.hotelstayplus.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
    @Query("SELECT c FROM Client c WHERE c.username = :username AND c.password = :password")
    Client findLoginClient(String username, String password);
}
