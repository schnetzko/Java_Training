package dependency_injection;

public class BankConsumerImpl implements IPaymentConsumer{

	private IPaymentService paymentService;
	
	BankConsumerImpl(IPaymentService paymentService){
		this.paymentService = paymentService;
	}
	
	@Override
	public void orderPayment(Long money){
		this.paymentService.pay(money);
	}
}
