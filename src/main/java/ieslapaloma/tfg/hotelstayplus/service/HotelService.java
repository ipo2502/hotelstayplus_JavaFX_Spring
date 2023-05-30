package ieslapaloma.tfg.hotelstayplus.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import ieslapaloma.tfg.hotelstayplus.model.Client;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import ieslapaloma.tfg.hotelstayplus.repository.HotelRepository;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    
    public HotelService (HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
