package aplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entites.Contract;
import model.services.ContractService;
import model.services.OnlinePaymentService;
import model.services.PaypalService;

public class program {

	
	public static void main (String []args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do contrato");
		System.out.print("Numero: ");
		int number= sc.nextInt();
		System.out.print("Data (dd/MM/yyy): ");
		sc.nextLine();
		LocalDate date=   LocalDate.parse(sc.nextLine(),ftm);
		System.out.print("Valor do contrato: ");
		double valueContract= sc.nextDouble();
		System.out.print("Entre com o numero de parcelas: ");
		Integer instalment = sc.nextInt();
		Contract obj = new Contract(number, date,valueContract);
		ContractService contractService = new  ContractService( new PaypalService());
		contractService.processContract(obj,instalment);
		System.out.println("Parcelas: ");
		System.out.println(obj.toString());
	}
}
