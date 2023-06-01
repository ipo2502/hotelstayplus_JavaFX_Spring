package ieslapaloma.tfg.hotelstayplus.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ieslapaloma.tfg.hotelstayplus.model.Service;
import ieslapaloma.tfg.hotelstayplus.repository.ServiceRepository;
@org.springframework.stereotype.Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public ServiceService (ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public List<Service> getServicesByHotelId(Long id) {
        return serviceRepository.findServicesByHotelId(id);
    }
    
}
