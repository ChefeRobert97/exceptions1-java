package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class VeryBadVersion {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Room number: ");
		Integer roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		Reservation reservation = new Reservation();
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must beafter check-in date");
		}
		else {
			reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must beafter check-in date");
			}
			else if (!checkIn.after(reservation.getCheckIn()) || !checkOut.after(reservation.getCheckOut())) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}

			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println(reservation);
			}
		}

		sc.close();
		
	}
}
