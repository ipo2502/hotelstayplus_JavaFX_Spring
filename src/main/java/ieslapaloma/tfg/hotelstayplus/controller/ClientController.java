package ieslapaloma.tfg.hotelstayplus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ieslapaloma.tfg.hotelstayplus.model.Client;
import ieslapaloma.tfg.hotelstayplus.service.ClientService;

@RestController
@RequestMapping(("/api/clients"))

public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
    
}
