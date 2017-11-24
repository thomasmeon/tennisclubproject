package cz.fi.muni.pa165.facade;

import java.util.List;

public class BookingFacade {
	
	List<BookingDTO> findAllBooking();

	void createBooking(long idBooking, long idCourt, long idPlayer1, long idPlayer2, date dateOfBooking, Hour24 hourOfBooking);
	
	void deleteBooking(long idBooking)
}
