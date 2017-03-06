package dependency_injection;

public class VisaPaymentServiceInjectorImpl implements IPaymentServiceInjector {

	@Override
	public IPaymentConsumer getPaymentConsumer() {
		return new BankConsumerImpl (new VisaPaymentImpl());
	}
}
