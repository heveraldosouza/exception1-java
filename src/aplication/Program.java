package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		System.out.println("Room number: ");
		int number = sc.nextInt();
		
		System.out.println("Chek-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		
		System.out.println("Chek-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erros na reserva: Checou-out data deve ser após a data de check-in 1");
		}else{
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " +  reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			
			System.out.println("Chek-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			
			System.out.println("Chek-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			
			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Erro na reserva: " + error);
			}else{	
				System.out.println("Reservation: " + reservation);
			}	
			
		}
			
		
		sc.close();
	}

}
