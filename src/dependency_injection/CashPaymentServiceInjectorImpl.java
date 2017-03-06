package dependency_injection;

public class CashPaymentServiceInjectorImpl implements IPaymentServiceInjector {

	@Override
	public IPaymentConsumer getPaymentConsumer() {
		return new BankConsumerImpl (new CashPaymentImpl());
	}
}
