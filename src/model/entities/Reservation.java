package model.entities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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

	public String updateDates(Date checkIn2, Date checkOut2) {
		if (!checkIn2.after(checkIn) || !checkOut2.after(checkOut)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		}
		if (!checkOut2.after(checkIn2)) {
			return "Error in reservation: Check-out date must beafter check-in date";
		}
		
		checkIn = checkIn2;
		checkOut = checkOut2;

		return null;
	}

	@Override
	public String toString() {
		return "Reservation: Room " +  roomNumber + ", check-in: " +  sdf.format(checkIn) + ", check-out: "
				+ sdf.format(checkOut) + ", " + duration() + " nights";
	}

}
