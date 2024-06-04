package model.entities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Error in reservation: Check-out date must beafter check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);	
	}

	public void updateDates(Date checkIn2, Date checkOut2) {
		if (!checkIn2.after(checkIn) || !checkOut2.after(checkOut)) {
			throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
		}
		if (!checkOut2.after(checkIn2)) {
			throw new DomainException("Error in reservation: Check-out date must beafter check-in date");
		}
		// • Cláusula throws: propaga a exceção ao invés de trata-la
		// • Cláusula throw: lança a exceção / "corta" o método
		// IllegalArgumentException é usada quando os argumentos que passamos para o método são inválidos
		// DomainException exceção personalizada 

		checkIn = checkIn2;
		checkOut = checkOut2;
	}

	@Override
	public String toString() {
		return "Reservation: Room " +  roomNumber + ", check-in: " +  sdf.format(checkIn) + ", check-out: "
				+ sdf.format(checkOut) + ", " + duration() + " nights";
	}

}
