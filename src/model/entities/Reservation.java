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
	
	public Reservation(Integer roomNumber, Date checkiIn, Date cehckOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkiIn;
		this.checkOut = cehckOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckiIn() {
		return checkIn;
	}

	public Date getCehckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();  
		return TimeUnit.DAYS.convert(diff, TimeUnit.MICROSECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room "         + roomNumber + 
			   ", check-in: "  + sdf.format(checkIn ) +
			   ", check-out: " + sdf.format(checkOut) +
			   ", "            + duration() +
			   " nights";
			   
			   
	}
	
	
}