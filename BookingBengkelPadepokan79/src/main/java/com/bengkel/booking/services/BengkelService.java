package com.bengkel.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bengkel.booking.models.BookingOrder;
import com.bengkel.booking.models.Customer;
import com.bengkel.booking.models.ItemService;
import com.bengkel.booking.models.MemberCustomer;
import com.bengkel.booking.models.Vehicle;

public class BengkelService {
	
	//Silahkan tambahkan fitur-fitur utama aplikasi disini
	
	//Login
	
	//Info Customer
	
	//Booking atau Reservation
	public static void bookingBengkel(Scanner input, List<Vehicle> listAllCustomersVehicles, List<ItemService> listServices, Customer customer, List<BookingOrder> listBookingOrders){
		String vehicleId ,serviceId, choice, metodePembayaran = "Cash";
		int attemp = 0;
		double totalServicePrice = 0;
		List<ItemService> customerService = new ArrayList<>();
		boolean isLooping = true;

		do {
			System.out.println("Masukkan Vehicle Id:");
			vehicleId = input.nextLine();
		} while (!Validation.validateVehicleById(vehicleId, listAllCustomersVehicles));

		PrintService.printService(listServices, Validation.getVehicleType(vehicleId, listAllCustomersVehicles));
		
		do {

			do {
				System.out.println("Masukkan Service Id:");
				serviceId = input.nextLine();
			} while (!Validation.validateServiceById(serviceId, listServices));

			customerService.add(Validation.getServiceById(serviceId, listServices));
			attemp++;

			if (customer.getMaxNumberOfService() != attemp) {
				do {
					System.out.println("Apakah anda ingin menambahkan Service Lainnya? (Y/N)");
					choice = input.nextLine();
				} while (!Validation.validate2Choice(choice, "Y", "N"));

				if (choice.equalsIgnoreCase("N")) {
					isLooping = false;
				}
			}

		} while (customer.getMaxNumberOfService() != attemp && isLooping);

		for (ItemService itemService : customerService) {
			totalServicePrice += itemService.getPrice();
		}
		
		if (customer instanceof MemberCustomer) {

			do {
				System.out.println("Silahkan Pilih Metode Pembayaran (Saldo Coin atau Cash)");
				metodePembayaran = input.nextLine();
			} while (!Validation.validate2Choice(metodePembayaran, "Saldo Coin", "Cash"));

			if (metodePembayaran.equalsIgnoreCase("Saldo Coin")) {
				boolean isEnoughMoney = Validation.isEnoughMoney(totalServicePrice, (MemberCustomer)customer);

				if (!isEnoughMoney) {
					System.out.println("Saldo Tidak Cukup, Akan Dialihkan Ke Pembayaran Cash");
					metodePembayaran = "Cash";
				} else {
					double saldoCoinCustomer = ((MemberCustomer)customer).getSaldoCoin();
					((MemberCustomer)customer).setSaldoCoin(saldoCoinCustomer -= totalServicePrice);
				}
			}
		}

		BookingOrder bookingOrder = new BookingOrder(generateBookingOrderId(customer.getCustomerId()), customer, customerService, metodePembayaran, totalServicePrice, 0);
		bookingOrder.calculatePayment();
		listBookingOrders.add(bookingOrder);

		System.out.println("Booking Berhasil!!");
		System.out.println("Total Harga Service : " + String.format("%,.2f", totalServicePrice));
		System.out.println("Total Harga Pembayaran : " + String.format("%,.2f", bookingOrder.getTotalPayment()));
		System.out.println();
	}

	public static String generateBookingOrderId(String customerId) {
		int number = 1;
		String bookingOrderId = "Book-" + customerId + "-" + String.format("%03d", number);
		number++;
		return bookingOrderId;
	  }
	
	//Top Up Saldo Coin Untuk Member Customer
	public static void tambahSaldo(Customer customer){
		if (customer instanceof MemberCustomer) {
			double saldoTambah = Double.parseDouble(Validation.validasiInput("Masukan Jumlah Saldo Yang Ditambahkan: ", "Input Harus Berupa Angka!", "^[0-9]+$"));
			double saldo = ((MemberCustomer)customer).getSaldoCoin();

			((MemberCustomer)customer).setSaldoCoin(saldo + saldoTambah);

		} else {
			System.out.println("Maaf Fitur Ini Hanya Untuk Member");
		}
		System.out.println();
	}
	
	//Logout
	
}
