package com.bengkel.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bengkel.booking.models.BookingOrder;
import com.bengkel.booking.models.Customer;
import com.bengkel.booking.models.ItemService;
import com.bengkel.booking.repositories.CustomerRepository;
import com.bengkel.booking.repositories.ItemServiceRepository;

public class MenuService {
	private static List<Customer> listAllCustomers = CustomerRepository.getAllCustomer();
	private static List<ItemService> listAllItemService = ItemServiceRepository.getAllItemService();
	private static List<BookingOrder> listAllBookingOrders = new ArrayList<>();
	private static Scanner input = new Scanner(System.in);
	private static String customerIdGeneral = "";

	public static void run() {
		boolean isLooping = true;
		do {
			login();
			mainMenu();
		} while (isLooping);

	}

	public static void login() {
		int attemp = 1;
		boolean isLooping = true;

		do {
			String customerId, password;

			System.out.println("Masukkan Customer Id");
			customerId = input.nextLine();
			System.out.println("Password");
			password = input.nextLine();
			boolean[] isValid = Validation.validasiLogin(customerId, listAllCustomers, password);

			if (isValid[0] && isValid[1]) {
				isLooping = false;
				customerIdGeneral = customerId;
			} else if (attemp == 3) {
				System.exit(0);
			}

			attemp++;
			System.out.println();
		} while (isLooping);
	}

	public static void mainMenu() {
		String[] listMenu = { "Informasi Customer", "Booking Bengkel", "Top Up Bengkel Coin", "Informasi Booking",
				"Logout" };
		int menuChoice = 0;
		boolean isLooping = true;

		do {
			PrintService.printMenu(listMenu, "Booking Bengkel Menu");
			menuChoice = Validation.validasiNumberWithRange("Masukan Pilihan Menu: ", "Input Harus Berupa Angka!",
					"^[0-9]+$", listMenu.length - 1, 0);

			switch (menuChoice) {
				case 1:
					// panggil fitur Informasi Customer
					PrintService.printCustomer(Validation.getCustomerById(customerIdGeneral, listAllCustomers));
					break;
				case 2:
					// panggil fitur Booking Bengkel
					BengkelService.bookingBengkel(input,
							Validation.getCustomerById(customerIdGeneral, listAllCustomers).getVehicles(),
							listAllItemService, Validation.getCustomerById(customerIdGeneral, listAllCustomers),
							listAllBookingOrders);
					break;
				case 3:
					// panggil fitur Top Up Saldo Coin
					BengkelService.tambahSaldo(Validation.getCustomerById(customerIdGeneral, listAllCustomers));
					break;
				case 4:
					// panggil fitur Informasi Booking Order
					PrintService.printBooking(listAllBookingOrders);
					break;
				default:
					System.out.println("Logout");
					System.out.println("Terimakasih !!");
					isLooping = false;
					break;
			}
		} while (isLooping);

	}

	// Silahkan tambahkan kodingan untuk keperluan Menu Aplikasi
}
