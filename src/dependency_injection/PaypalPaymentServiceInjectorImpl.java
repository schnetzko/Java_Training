package dependency_injection;

public class PaypalPaymentServiceInjectorImpl implements IPaymentServiceInjector{

	@Override
	public IPaymentConsumer getPaymentConsumer(){
		return new BankConsumerImpl (new PaypalPaymentImpl());
	}
}
