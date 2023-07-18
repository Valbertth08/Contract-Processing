package model.services;

public class PaypalService  implements OnlinePaymentService{

	
	@Override
	public double PaymentFree(double amount) {
		double valor= (amount*0.02);
		return valor+amount;
	}

	@Override
	public double interest(double amount, Integer months) {
		double valor= (amount*0.01)*months;
		return 	amount+valor;
	}

}
