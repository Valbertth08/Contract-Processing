package model.services;

import model.entites.Contract;
import model.entites.Installment;

public class ContractService {

	private OnlinePaymentService service;
	
	public ContractService() {
		
	}
	
	public ContractService(OnlinePaymentService service) {
		this.service = service;
	}


	public OnlinePaymentService getService() {
		return service;
	}

	public void setService(OnlinePaymentService service) {
		this.service = service;
	}

	public void processContract(Contract contract, Integer months) {
		for( int i =1; i<=months ;i++) {
			double interest =service.interest(contract.getTotalValue()/months,i);
			double fee =service.PaymentFree(interest);
			contract.getList().add(new Installment(contract.getDate().plusMonths(i),fee));
		}
	}
}
