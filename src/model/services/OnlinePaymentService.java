package model.services;

public interface OnlinePaymentService {

	public double PaymentFree(double amount);
	public double interest(double amount, Integer months);
	
	
}
