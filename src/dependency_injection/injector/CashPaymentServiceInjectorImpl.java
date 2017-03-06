package dependency_injection.injector;

import dependency_injection.consumer.BankConsumerImpl;
import dependency_injection.consumer.IPaymentConsumer;
import dependency_injection.service.CashPaymentServiceImpl;

/**
 * @author schnetzko
 *
 * This class generates app-objects (here BankConsumerImpl) which are already initialized
 * with the service implementation that they used for (here CashPaymentServiceImpl).
 */
public class CashPaymentServiceInjectorImpl implements IPaymentServiceInjector {

	@Override
	public IPaymentConsumer getPaymentConsumer() {
		return new BankConsumerImpl (new CashPaymentServiceImpl());
	}
}
