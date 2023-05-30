package ieslapaloma.tfg.hotelstayplus.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ieslapaloma.tfg.hotelstayplus.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
