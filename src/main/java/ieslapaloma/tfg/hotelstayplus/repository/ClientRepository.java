package ieslapaloma.tfg.hotelstayplus.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import ieslapaloma.tfg.hotelstayplus.javafx.Models.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
