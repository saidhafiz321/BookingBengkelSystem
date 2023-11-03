package com.bengkel.booking.services;

import java.util.List;
import java.util.Scanner;

import com.bengkel.booking.models.Car;
import com.bengkel.booking.models.Customer;
import com.bengkel.booking.models.ItemService;
import com.bengkel.booking.models.MemberCustomer;
import com.bengkel.booking.models.Motorcyle;
import com.bengkel.booking.models.Vehicle;

public class Validation {
	
	public static String validasiInput(String question, String errorMessage, String regex) {
	    Scanner input = new Scanner(System.in);
	    String result;
	    boolean isLooping = true;
	    do {
	      System.out.print(question);
	      result = input.nextLine();

	      //validasi menggunakan matches
	      if (result.matches(regex)) {
	        isLooping = false;
	      }else {
	        System.out.println(errorMessage);
	      }

	    } while (isLooping);

	    return result;
	  }
	
	public static int validasiNumberWithRange(String question, String errorMessage, String regex, int max, int min) {
	    int result;
	    boolean isLooping = true;
	    do {
	      result = Integer.valueOf(validasiInput(question, errorMessage, regex));
	      if (result >= min && result <= max) {
	        isLooping = false;
	      }else {
	        System.out.println("Pilihan angka " + min + " s.d " + max);
	      }
	    } while (isLooping);

	    return result;
	  }

	  public static boolean[] validasiLogin(String customerId, List<Customer> listAllCustomers, String password){
		boolean isValid[] = {false, false};
		int indexId = 0;

		for (int index = 0; index < listAllCustomers.size(); index++) {
			if (customerId.equals(listAllCustomers.get(index).getCustomerId())) {
				isValid[0] = true;
				indexId = index;
				break;
			}
		}

			if (password.equals(listAllCustomers.get(indexId).getPassword())) {
				isValid[1] = true;
			}

		if (!isValid[0]) {
			System.out.println("Customer Id Tidak Ditemukan atau Salah");
		} 

		if (!isValid[1]) {
			System.out.println("Password Salah");
		}

		return isValid;
	  }

	  public static Customer getCustomerById(String customerId, List<Customer> listAllCustomers){
		Customer customer = new Customer();

		for (int index = 0; index < listAllCustomers.size(); index++) {
			if (customerId.equalsIgnoreCase(listAllCustomers.get(index).getCustomerId())) {
				customer = listAllCustomers.get(index);
				break;
			}
		}

		return customer;
	  }

	  public static boolean validateVehicleById(String customerId, List<Vehicle> listAllCustomersVehicles){
		boolean isValid = false;

		for (int index = 0; index < listAllCustomersVehicles.size(); index++) {
			if (customerId.equalsIgnoreCase(listAllCustomersVehicles.get(index).getVehiclesId())) {
				isValid = true;
				break;
			} 
		}

		if (!isValid) {
			System.out.println("Vehicle Id Tidak Diketahui");
		}

		return isValid;
	  }

	  public static String getVehicleType(String customerId, List<Vehicle> listAllCustomersVehicles){
		String vehicleType = "";

		for (int index = 0; index < listAllCustomersVehicles.size(); index++) {
			if (customerId.equalsIgnoreCase(listAllCustomersVehicles.get(index).getVehiclesId()) ) {
				if (listAllCustomersVehicles.get(index) instanceof Motorcyle) {
					vehicleType = "Motorcyle";
					break;
				} else {
					vehicleType = "Car";
					break;
				}
			} 
		}

		return vehicleType;
	  }

	  public static boolean validateServiceById(String ServiceId, List<ItemService> listAllService){
		boolean isValid = false;

		for (int index = 0; index < listAllService.size(); index++) {
			if (ServiceId.equalsIgnoreCase(listAllService.get(index).getServiceId())) {
				isValid = true;
				break;
			} 
		}

		if (!isValid) {
			System.out.println("Service Id Tidak Diketahui");
		}
		return isValid;
	  }

	  public static boolean validate2Choice(String input, String compare1, String compare2){
		boolean isValid = false;

		if (input.equalsIgnoreCase(compare1) || input.equalsIgnoreCase(compare2)) {
				isValid = true;
			} else{
				System.out.println("Input Tidak Sesuai");
			}
			
			return isValid;
		}

	  public static ItemService getServiceById(String ServiceId, List<ItemService> listAllService){
		ItemService service = new ItemService();

		for (int index = 0; index < listAllService.size(); index++) {
			if (ServiceId.equalsIgnoreCase(listAllService.get(index).getServiceId())) {
				service = listAllService.get(index);
				break;
			} 
		}

		return service;
	  }

	  public static boolean isEnoughMoney(double moneyToPay, MemberCustomer customer){
		boolean isEnoughMoney = false;

		if (customer.getSaldoCoin() > moneyToPay){
			isEnoughMoney = true;
		} else{
			System.out.println("Saldo Tidak Cukup");
		}

		return isEnoughMoney;
	  }
}
