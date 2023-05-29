package ieslapaloma.tfg.hotelstayplus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ieslapaloma.tfg.hotelstayplus.repository.HotelRepository;
import ieslapaloma.tfg.hotelstayplus.service.HotelService;

@Component
public class MyComponent {

    private final RepositoryServiceManager repositoryServiceManager;

    @Autowired
    public MyComponent(RepositoryServiceManager repositoryServiceManager) {
        this.repositoryServiceManager = repositoryServiceManager;
    }

    public void doSomething() {
        HotelRepository hotelRepository = repositoryServiceManager.getHotelRepository();
        HotelService hotelService = repositoryServiceManager.getHotelService();

        System.out.println("AAAAAAAAAAAAAA: "+hotelService.getAllHotels().size());
    }
}

