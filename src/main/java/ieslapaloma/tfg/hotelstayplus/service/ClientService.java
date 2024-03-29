package ieslapaloma.tfg.hotelstayplus.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import ieslapaloma.tfg.hotelstayplus.model.Client;
import ieslapaloma.tfg.hotelstayplus.repository.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public ClientService (ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client loginClient(String username, String password) {
        return clientRepository.findLoginClient(username, password);
    }

}
