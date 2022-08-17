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
	
	public Reservation(Integer roomNumber, Date checkiIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkiIn;
		this.checkOut = checkOut;
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

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();  
		return TimeUnit.DAYS.convert(diff, TimeUnit.MICROSECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "As datas de reserva para atualiza��o devem ser futuras 2";
		}	
		if( !checkOut.after(checkIn) ){
			return  "Os dados de check-out devem ser posteriores � data de check-in 3";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
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