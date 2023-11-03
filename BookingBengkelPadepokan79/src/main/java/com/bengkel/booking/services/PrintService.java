package com.bengkel.booking.services;

import java.util.List;

import com.bengkel.booking.models.BookingOrder;
import com.bengkel.booking.models.Car;
import com.bengkel.booking.models.Customer;
import com.bengkel.booking.models.ItemService;
import com.bengkel.booking.models.MemberCustomer;
import com.bengkel.booking.models.Motorcyle;
import com.bengkel.booking.models.Vehicle;

public class PrintService {
	
	public static void printMenu(String[] listMenu, String title) {
		String line = "+---------------------------------+";
		int number = 1;
		String formatTable = " %-2s. %-25s %n";
		
		System.out.printf("%-25s %n", title);
		System.out.println(line);
		
		for (String data : listMenu) {
			if (number < listMenu.length) {
				System.out.printf(formatTable, number, data);
			}else {
				System.out.printf(formatTable, 0, data);
			}
			number++;
		}
		System.out.println(line);
		System.out.println();
	}
	
	public static void printVechicle(List<Vehicle> listVehicle) {
		String formatTable = "| %-2s | %-15s | %-10s | %-15s | %-15s | %-5s | %-15s |%n";
		String line = "+----+-----------------+------------+-----------------+-----------------+-------+-----------------+%n";
		System.out.format(line);
	    System.out.format(formatTable, "No", "Vechicle Id", "Warna", "Brand", "Transmisi", "Tahun", "Tipe Kendaraan");
	    System.out.format(line);
	    int number = 1;
	    String vehicleType = "";
	    for (Vehicle vehicle : listVehicle) {
	    	if (vehicle instanceof Car) {
				vehicleType = "Mobil";
			}else {
				vehicleType = "Motor";
			}
	    	System.out.format(formatTable, number, vehicle.getVehiclesId(), vehicle.getColor(), vehicle.getBrand(), vehicle.getTransmisionType(), vehicle.getYearRelease(), vehicleType);
	    	number++;
	    }
	    System.out.printf(line);
	}
	
	//Silahkan Tambahkan function print sesuai dengan kebutuhan.

	public static void printCustomer(Customer customer) {
		String formatMember = "%-16s: %-15s %n";
		String customerStatus = "Non Member";

		if (customer instanceof MemberCustomer) {
			customerStatus = "Member";
		}
	    
		System.out.printf(formatMember, "Customer Id", customer.getCustomerId());
		System.out.printf(formatMember, "Nama", customer.getName());
		System.out.printf(formatMember, "Customer Status", customerStatus);
		System.out.printf(formatMember, "Alamat", customer.getAddress());

		if (customer instanceof MemberCustomer) {
			System.out.printf(formatMember, "Saldo Koin", ((MemberCustomer)customer).getSaldoCoin());
		}

	    printVechicle(customer.getVehicles());
		System.out.println();
	}

	public static void printService(List<ItemService> listServices, String vehicleType) {
		int number = 1;
		String formatTable = "| %-2s | %-15s | %-15s | %-15s | %-10s |%n";
		String line = "+----+-----------------+-----------------+-----------------+------------+%n";
		System.out.format(line);
	    System.out.format(formatTable, "No", "Service Id", "Nama Service", "Tipe Kendaraan", "Harga");
	    System.out.format(line);

	    for (ItemService service : listServices) {
			if (service.getVehicleType().equalsIgnoreCase(vehicleType)) {
				System.out.format(formatTable, number, service.getServiceId(), service.getServiceName(), service.getVehicleType(), String.format("%,.2f", (service.getPrice())));
				number++;
			}
		}

	    System.out.printf(line);
	}

	public static void printBooking(List<BookingOrder> listBookingOrders) {
		int number = 1;
		String formatTable = "| %-2s | %-17s | %-15s | %-15s | %-15s | %-15s | %-30s |%n";
		String line = "+----+-------------------+-----------------+-----------------+-----------------+-----------------+----------------------------------+%n";
		System.out.format(line);
	    System.out.format(formatTable, "No", "Booking Id", "Nama Customer", "Payment Method", "Total Service", "Total Payment", "List Service");
	    System.out.format(line);

	    for (BookingOrder bookingOrder : listBookingOrders) {
			System.out.format(formatTable, number, bookingOrder.getBookingId(), bookingOrder.getCustomer().getName(), bookingOrder.getPaymentMethod(), String.format("%,.2f", (bookingOrder.getTotalServicePrice())), String.format("%,.2f", (bookingOrder.getTotalPayment())), printListService(bookingOrder.getServices()));
			number++;
			}
			System.out.printf(line);
		}
	

	private static String printListService(List<ItemService> listServices){
		String result = "";
		int totalItem = 1;

		for (ItemService itemService : listServices) {
			if (listServices.size() == totalItem) {
				result += itemService.getServiceName();
			} else {
				result += itemService.getServiceName() + ", ";
			}
			totalItem++;
		}
		return result;
	}
}
