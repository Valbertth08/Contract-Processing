package model.services;

import model.entites.Contract;
import model.entites.Installment;

public class ContractService {

	private OnlinePaymentService service;
	
	public ContractService() {
		
	}
	
	public OnlinePaymentService getService() {
		return service;
	}

	public void setService(OnlinePaymentService service) {
		this.service = service;
	}

	public void processContract(Contract contract, Integer months) {
		service = new PaypalService();
		for( int i =1; i<=months ;i++) {
			double amount =service.interest(contract.getTotalValue()/months,i);
			double valor =service.PaymentFree(amount);
			contract.getList().add(new Installment(contract.getDate().plusMonths(i),valor));
		}
	}
}
