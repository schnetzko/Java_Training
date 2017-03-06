package dependency_injection.consumer;

import dependency_injection.service.IPaymentService;

public class BankConsumerImpl implements IPaymentConsumer{

	private IPaymentService paymentService;
	
	public BankConsumerImpl(IPaymentService paymentService){
		this.paymentService = paymentService;
	}
	
	@Override
	public void orderPayment(Long money){
		this.paymentService.pay(money);
	}
}
