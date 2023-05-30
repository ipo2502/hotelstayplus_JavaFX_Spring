package ieslapaloma.tfg.hotelstayplus.javafx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ieslapaloma.tfg.hotelstayplus.model.Client;
import ieslapaloma.tfg.hotelstayplus.repository.ClientRepository;

public class lokuraControll {
    @Autowired
    private static ClientRepository clientRepository; // Assuming you have a UserRepository class
    private static lokuraControll instance;

    public static lokuraControll getInstance(ClientRepository clientRepository2) {
        if (instance == null) {
            instance = new lokuraControll();
        }
        return instance;
    }

    public List<Client> getClientes() {
        return  clientRepository.findAll();
    }
    
}
