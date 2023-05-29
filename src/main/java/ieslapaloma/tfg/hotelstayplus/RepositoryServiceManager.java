package ieslapaloma.tfg.hotelstayplus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ieslapaloma.tfg.hotelstayplus.repository.HotelRepository;
import ieslapaloma.tfg.hotelstayplus.service.HotelService;

@Component
public class RepositoryServiceManager {

    private final HotelRepository hotelRepository;
    private final HotelService hotelService;

    @Autowired
    public RepositoryServiceManager(HotelRepository hotelRepository, HotelService hotelService) {
        this.hotelRepository = hotelRepository;
        this.hotelService = hotelService;
    }

    public HotelRepository getHotelRepository() {
        return hotelRepository;
    }

    public HotelService getHotelService() {
        return hotelService;
    }
}

