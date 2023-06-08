package ieslapaloma.tfg.hotelstayplus.service;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ieslapaloma.tfg.hotelstayplus.javafx.Model.Model;
import ieslapaloma.tfg.hotelstayplus.model.Booking;
import ieslapaloma.tfg.hotelstayplus.model.Hotel;
import ieslapaloma.tfg.hotelstayplus.repository.BookingRepository;

@Service
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;

    public BookingService (BookingRepository clientRepository) {
        this.bookingRepository = clientRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking addBooking(Booking booking) {
        return bookingRepository.saveAndFlush(booking);
    }

    public List<Booking> getAllBookingsByClientId(Long id) {
        return bookingRepository.findBookingsByClientId(id);
    }

    public boolean createBooking(Booking booking) {
        Hotel hotel = booking.getHotel();
        LocalDate dateStart = booking.getDateStart();
        LocalDate dateEnd = booking.getDateEnd();

        // Check for overlapping bookings
        List<Booking> conflictingBookings = bookingRepository.findByHotelAndDateRange(hotel, dateStart, dateEnd);

        if (!conflictingBookings.isEmpty()) {
            // Handle overlapping bookings (e.g., throw an exception or show an error message)
            // ...
            System.out.println("ERROR: NO SE PUEDE AÑADIR PORQUE LAS FECHAS COLISIONAN");
            Model.getInstance().setSuccessfulBookingFlag(false);
            return false;
        } else {
            // No conflicting bookings, proceed with saving the booking
            bookingRepository.save(booking);
            Model.getInstance().setSuccessfulBookingFlag(true);

            return true;
        }
    }


}
