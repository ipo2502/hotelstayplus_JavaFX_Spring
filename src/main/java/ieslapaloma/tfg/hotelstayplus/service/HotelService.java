package ieslapaloma.tfg.hotelstayplus.service;
import java.util.List;
import java.util.Optional;

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

    public Optional<Hotel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.saveAndFlush(hotel);
    }

    public void deleteHotelById(Long id) {
        hotelRepository.deleteById(id);
    }

    public Hotel updateHotel(Hotel hotel) {
        return hotelRepository.saveAndFlush(hotel);
    }

    public List<ieslapaloma.tfg.hotelstayplus.model.Service> getHotelServicesById(Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        return hotel.getServices();
    }
}
